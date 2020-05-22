import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientProperties;

public class ClientProgram {
    public static void main(final String[] args) throws IOException {
        Client client = null;
        try {
            client = ClientBuilder.newClient();
            client.property(ClientProperties.READ_TIMEOUT, 10000);

            try (final InputStream inputStream = client
                .target("http://localhost:8080/")
                .request(MediaType.APPLICATION_JSON)
                .get(InputStream.class);
                final BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
                processStream(bufferedInputStream);
            }
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    private static void processStream(final InputStream inputStream) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final JsonFactory jsonFactory = objectMapper.getFactory();
        try (final JsonParser jsonParser = jsonFactory.createParser(inputStream)) {
            final JsonToken arrayToken = jsonParser.nextToken();
            if (arrayToken == null) {
                // TODO: Return or throw exception.
                return;
            }

            if (!JsonToken.START_ARRAY.equals(arrayToken)) {
                // TODO: Return or throw exception.
                return;
            }

            // Iterate through the objects of the array.
            while (JsonToken.START_OBJECT.equals(jsonParser.nextToken())) {
                final ResponseData responseData = jsonParser.readValueAs(ResponseData.class);
                System.out.println(responseData);
            }
        }
    }
}