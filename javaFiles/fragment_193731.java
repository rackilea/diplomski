public interface ClientCallbackInterface extends Remote {

    void ping() throws RemoteException;

    void notifyChanges(...) throws RemoteException;

}