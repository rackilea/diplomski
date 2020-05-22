import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;


public class Test {
    @org.junit.Test
    public void test() {
        ClientConfig cc = new ClientConfig().connectorProvider(new ApacheConnectorProvider());
        Client client = ClientBuilder.newClient(cc);
        System.out.println(client.target("http://example.com/").request().get().getStatus());
    }
}