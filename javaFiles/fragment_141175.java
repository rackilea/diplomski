import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.OutputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

@Path("/")
public class TestResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        final StreamingOutput streamingOutput = new JsonStreamingOutput();
        return Response.status(200).entity(streamingOutput).build();
    }

    private static class JsonStreamingOutput implements StreamingOutput {
        @Override
        public void write(final OutputStream outputStream) throws IOException, WebApplicationException {
            final ObjectMapper objectMapper = new ObjectMapper();
            final JsonFactory jsonFactory = objectMapper.getFactory();
            try (final JsonGenerator jsonGenerator = jsonFactory.createGenerator(outputStream)) {
                jsonGenerator.writeStartArray();

                for (int i = 0; i < 10; i++) {
                    final ResponseData responseData = new ResponseData(
                        "Response State - " + i,
                        "Response Report - " + i,
                        "Error Details - " + i
                    );
                    jsonGenerator.writeObject(responseData);
                    jsonGenerator.flush();

                    try {
                        Thread.currentThread().sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                jsonGenerator.writeEndArray();
            }
        }
    }
}