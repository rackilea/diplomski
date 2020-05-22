public class ClientConverter extends StringConverter<Client> {
    private final ListCell<Client> cell;
    public ClientConverter(ListCell<Client> cell) {
        this.cell = cell ;
    }
    @Override
    public String toString(Client client) {
        return client.getName();
    }

    @Override
    public Client fromString(String string) {
        Client client = cell.getItem();
        client.setName(string);
        return client ;
    }

}