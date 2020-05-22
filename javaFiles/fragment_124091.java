import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.DatatypeConverter;

public class DemoClient {

    public static void main(String[] args) throws Exception {
        Client client = ClientBuilder.newClient();

        URI uri = URI.create("http://localhost:8000");
        Map<String, List<Object>> headers = new HashMap<>();
        headers.put(HttpHeaders.ACCEPT, Arrays.asList((Object) MediaType.APPLICATION_JSON));

        PostRequestData requestData = new PostRequestData(uri, headers, new String("hello world"));

        Response response = requestData.post(client);
        if (response.getStatus() != Status.ACCEPTED.getStatusCode()) {

            // let's serialise it into binary
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
            objectOutputStream.writeObject(requestData);
            // save bytestream or print it?
            String bin = DatatypeConverter.printHexBinary(byteStream.toByteArray());
            System.out.println(bin);

            // let's replay the request
            byte[] newBytes = DatatypeConverter.parseHexBinary(bin);
            ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(newBytes));
            PostRequestData newRequestdata = (PostRequestData) oin.readObject();

            Response newResponse = newRequestdata.post(client);

            if (newResponse.getStatus() != Status.ACCEPTED.getStatusCode()) {
                System.out.println("give up!");
            }
        }
    }

    static class PostRequestData implements Serializable {

        private static final long serialVersionUID = -5786067257552259115L;

        final URI uri;

        final Map<String, List<Object>>  headers;

        final Serializable entity; 

        public PostRequestData(URI uri, Map<String, List<Object>> headers, Serializable entity) {
            this.uri = uri;
            this.headers = headers;
            this.entity = entity;
        }

        public Response post(Client client) {
            MultivaluedHashMap<String, Object> multimap = new MultivaluedHashMap<String, Object>();
            headers.forEach((k,v) -> multimap.put(k, v));

            return client.target(uri)
                .request()
                .headers(multimap)
                .post(Entity.text(entity));
        }

    }

}