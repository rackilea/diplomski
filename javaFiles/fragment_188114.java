public class Client extends Player<ClientUnit> {

    public Client(ClientUnit unit) { 
       super(unit); 
    }

    public static void main(String[] args) {
        Client client = new Client(new ClientUnit());
        ClientUnit unit = client.getUnit();
    }
}