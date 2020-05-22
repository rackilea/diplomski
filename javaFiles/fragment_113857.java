public class Client {
private static final String BASE_URI = "http://localhost:8090/Test/gets";

public Client() throws IOException {

    try {
        Client client = Client.create();
        WebResource objWebResource = client.resource(BASE_URI);
        ClientResponse response = objWebResource.path("/").queryParam("id", "1")
            .type(javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM).get(ClientResponse.class);
        if (response.getStatus() == Status.OK.getStatusCode() && response.hasEntity()) {

            ObjectMapper mapper = new ObjectMapper(new BsonFactory()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            ResponseSample responseSample = mapper.readValue(response.getEntityInputStream(), ResponseSample.class);
        }
    } catch (UniformInterfaceException e) {
        e.printStackTrace();
    } catch (ClientHandlerException e) {
        e.printStackTrace();
    }

}
public static void main(String...args) throws IOException {
    new Client();
}