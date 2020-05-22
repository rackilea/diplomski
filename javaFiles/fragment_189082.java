/**
 * Class is not Thread Safe
 */
public class ClientList {
    private final ArrayList<string> clients;

    public ClientList() {
        this.clients = new ArrayList<>();
    }

    public void addClient(String client) {
        this.clients.add(client);
    }

    public List<String> getClients() {
        // Note: Never give a reference to the internal objects of the class
        // as that means someone outside this class can own a reference to it
        // and can update the object without you knowing (by not going
        // through this class)
        Collections.unmodifiableList(this.clients);
    }
}