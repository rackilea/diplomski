public class ServerService extends UnicastRemoteObject implements IServer {

    private ArrayList<IClient> clients;

    private Consumer<IClient> registerCallback = client -> {} ;
    private Consumer<IClient> unregisterCallback = client -> {} ;


    public ServerService() throws RemoteException {
        clients = new ArrayList<>();
    }

    public void setRegisterCallback(Consumer<IClient> registerCallback) {
        this.registerCallback = registerCallback ;
    }

    public void setUnregisterCallback(Consumer<IClient> unregisterCallback) {
        this.unregisterCallback = unregisterCallback ;
    }

    @Override
    public boolean register(IClient client) throws RemoteException {
        if(!clients.contains(client)) {
            clients.add(client);
            registerCallback.accept(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean unRegister(IClient client) throws RemoteException {
        if(clients.contains(client)) {
            clients.remove(client);
            unregisterCallback.accept(client);
            return true;
        }
        return false;
    }

    @Override
    public String ping() throws RemoteException {
        long arrival = System.currentTimeMillis();
        System.out.println("Got pinged at [" + arrival + "]");
        return ("server ponged [" + arrival + "]");
    }

    @Override
    public CommandResult sendCommand(ICommand command, IClient targetClient) throws RemoteException {
        if(clients.contains(targetClient)) {
            return clients.get(clients.indexOf(targetClient)).executeCommand(command);
        }
        return null;
    }

    @Override
    public ArrayList<IClient> getClients() {
        return clients;
    }
}