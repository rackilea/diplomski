public class ServerService extends UnicastRemoteObject implements IServer {

    private ObservableList<IClient> clients;

    public ServerService() throws RemoteException {
        clients = FXCollections.observableArrayList();
    }

    // ...

    @Override
    public ObservableList<IClient> getClients() {
        return clients;
    }
}