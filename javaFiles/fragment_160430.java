private final ObjectProperty<Client> client = new SimpleObjectProperty<>(this, "client");
public final Client getClient(){
    return clientProperty().get();
}
public final void setClient(Client client){
    clientProperty().set(client);
}

public ObjectProperty<Client> clientProperty(){
    return client;
}