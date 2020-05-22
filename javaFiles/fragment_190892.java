public class Client {
    private final int clientId;
    private final String moreFields;

    @JsonCreator
    public Client(@JsonProperty("clientId") int clientId, 
                  @JsonProperty("moreFields") String moreFields) {
        this.clientId = clientId;
        this.moreFields = moreFields;
    }

    @Override
    public String toString() {
        return "Client[clientId=" + clientId + ", moreFields=" + moreFields + "]";
    }
}