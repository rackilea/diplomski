@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "clientKey")
private Client clientKey;

//Getter & Setter
public Client getClientKey() {
    return clientKey;
}

public void setClientKey(Client client) {
    this.clientKey = client;
}