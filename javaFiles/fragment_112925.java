private void initClientListView() {
        System.out.println("clientListView");            
        serverClientsObservableList = FXCollections.observableArrayList(server.getClients());
        server.setRegisterCallback(client -> Platform.runLater(() -> 
            serverClientsObservableList.add(client)));
        server.setUnregisterCallback(client -> Platform.runLater(() ->
            serverClientsObservableList.remove(client)));
        clientListView.setItems(serverClientsObservableList);
}