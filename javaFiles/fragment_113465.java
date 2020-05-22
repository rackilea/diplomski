import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

interface ClientRemote extends Remote {
    public void doSomething() throws RemoteException;
}

interface ServerRemote extends Remote {
    public void registerClient(ClientRemote client) throws RemoteException;
}

class Client implements ClientRemote {
    public Client() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void doSomething() throws RemoteException {
        System.out.println("Server invoked doSomething()");
    }
}

class Server implements ServerRemote {
    private volatile ClientRemote client;

    public Server() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void registerClient(ClientRemote client) throws RemoteException {
        this.client = client;
    }

    public void doSomethingOnClient() throws RemoteException {
        client.doSomething();
    }
}