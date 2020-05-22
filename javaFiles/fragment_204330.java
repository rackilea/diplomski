while (true) {
    ClientService cs = new ClientService(serverSocket.accept());
    cs.messageProperty().addListener((obs, oldMessage, newMessage) -> {
        // update UI with newMessage...
    }
    Platform.runLater(cs::start);
    updateMessage("Connected");
}