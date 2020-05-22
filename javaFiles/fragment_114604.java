public class ClassToTest {

    private ClientFactory factory;

    public ClassTotest() {
        this(new ClientFactory());
    }

    public ClassToTest(ClientFactory factory) {
        this.factory = factory;
    }

    public void connect() {
        Client client = factory.getClient();
        WebResource jobBuilder = client.resource("URL");
        String jobXml = jobBuilder.accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(request)
                    .post(String.class);    
    }
}

public class ClientFactory() {
    public Client getClient() {
                ClientConfig cc = new DefaultClientConfig();
                cc.getClasses().add(JacksonJsonProvider.class);
                Client client = Client.create(cc);
                return client;
    }
}