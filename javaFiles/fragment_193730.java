public interface Server extends Remote {

    void register(Client client) throws RemoteException;

    void unregister(Client client) throws RemoteException;

    void doSomethingUseful(...) throws RemoteException;

    ...

}