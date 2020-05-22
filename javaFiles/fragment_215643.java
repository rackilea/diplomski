class ClientSocketFactory implements RMIClientSocketFactory,Serializable{

    private InetAddress address;

    public ClientSocketFactory(InetAddress address)
    {
        this.address = address;
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        Socket socket =new Socket(address, port);
        return socket;
    }

    @Override
    public boolean equals(Object that)
    {
        return that != null && this.getClass() == that.getClass();
    }
}

class ServerSocketFactory implements RMIServerSocketFactory{

    private InetAddress address;

    public ServerSocketFactory(InetAddress address)
    {
        this.address = address;
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException{  
        return new ServerSocket(port, 0, address);
    }

    @Override
    public boolean equals(Object that)
    {
        return that != null && this.getClass() == that.getClass();
    }
}

public class RmiRemoteManager {

    private Registry registry;

    private InetSocketAddress socketAddress;

    private ServerSocketFactory serverSocketFactory;

    private ClientSocketFactory clientSocketFactory;

    public RmiRemoteManager(InetSocketAddress socketAddress) {
        try {
            this.socketAddress = socketAddress;
            serverSocketFactory=new ServerSocketFactory(InetAddress.getByName(socketAddress.getHostName()));
            clientSocketFactory=new ClientSocketFactory(InetAddress.getByName(socketAddress.getHostName()));
            //the registry is exported via createRegistry.
            registry = LocateRegistry.createRegistry(this.socketAddress.getPort(),clientSocketFactory,serverSocketFactory);
        } catch (UnknownHostException ex) {
            Logger.getLogger(RmiRemoteManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RmiRemoteManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private synchronized static Remote export(Remote remoteObject,InetSocketAddress sa,ClientSocketFactory csf,ServerSocketFactory ssf){
        try {
            System.setProperty("java.rmi.server.hostname",sa.getHostName());
            return UnicastRemoteObject.exportObject(remoteObject,sa.getPort(),csf,ssf);
        } catch (RemoteException ex) {
            Logger.getLogger(RmiRemoteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void export(Remote remoteObject,String url){
        try {
            Remote stub=export(remoteObject,socketAddress,clientSocketFactory,serverSocketFactory);
            remoteObjects.add(remoteObject);
            if (url!=null){
                urlsByRemoteObjects.put(remoteObject, url);
                registry.rebind(url, stub);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(RmiRemoteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}