public interface ILawSuiteEE extends IConcurrentDatastore {

    void connect(String address, String port) throws RemoteException;

    void disconnect() throws RemoteException;

    boolean login(String username, char[] password) throws RemoteException;

}