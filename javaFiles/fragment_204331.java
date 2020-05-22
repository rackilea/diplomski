public class SocketService {

    private final ObservableMap<ClientService, String> messageLookup 
        = FXCollections.observableMap(new HashMap<>()) ;

    private final ObservableList<String> messages = FXCollections.observableArrayList();

    public ObservableList<String> getMessages() { return messages ; }

    int portNumber ;

    public SocketService(int portNumber) {

        this.portNumber = portNumber ;

        messageLookup.addListener((Change<? extends ClientService, ? extends String> change) -> {
            if (change.wasAdded()) {
                messages.add(change.getValueAdded());
            }
            if (change.wasRemoved()) {
                messages.remove(change.getValueRemoved());
            }
        });

        Task<Void> task = new Task<Void>() {
            @Override
            public void call() {
                try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
                    while(true) {
                        ClientService cs = new ClientService(serverSocket.accept());
                        cs.messageProperty().addListener((obs, oldMessage, newMessage) -> 
                            messageLookup.put(cs, newMessage));
                        Platform.runLater(cs::start);
                        updateMessage("Connected");
                    }
                } catch (...) { ... }
                return null ;
            }
        }
    }
}