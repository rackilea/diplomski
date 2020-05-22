import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.message.internal.ReaderWriter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

/**
 * Run it like any other JUnit test. Required dependencies are as follows:
 * 
 *  <dependency>
 *     <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *     <version>2.22.1</version>
 *     <scope>test</scope>
 *  </dependency>
 *     <dependency>
 *     <groupId>org.glassfish.jersey.media</groupId>
 *     <artifactId>jersey-media-multipart</artifactId>
 *     <version>2.22.1</version>
 *     <scope>test</scope>
 *  </dependency>
 * 
 */
public class Jersey2MultipartTest extends JerseyTest {

    @Path("service")
    public static class Service {

        @POST
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        @Produces(MediaType.TEXT_PLAIN)
        public String getTest(@FormDataParam("file") List<FormDataBodyPart> files) {
            for (FormDataBodyPart filePart: files) {
                ContentDisposition cd = filePart.getContentDisposition();
                try (FileOutputStream out = new FileOutputStream(cd.getFileName())) {
                    ReaderWriter.writeTo(filePart.getEntityAs(InputStream.class), out);
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    return "Oops";
                }
            }
            return "Upload OK";
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(Service.class)
                .register(MultiPartFeature.class);
    }

    @Override
    public void configureClient(ClientConfig config) {
        config.register(MultiPartFeature.class);
    }

    private static final String FILE_ONE = "<enter-file-location>";
    private static final String FILE_TWO = "<enter-file-location>";

    @Test
    public void doit() {
        MultiPart entity = new FormDataMultiPart();
        addFiles(entity, FILE_ONE, FILE_TWO);

        Response response = target("service").request()
                .post(Entity.entity(entity, MediaType.MULTIPART_FORM_DATA));
        assertEquals(200, response.getStatus());
        assertEquals("Upload OK", response.readEntity(String.class));
        response.close();
    }

    private void addFiles(MultiPart entity, String... files) {
        for (String file: files) {
            FileDataBodyPart filePart = new FileDataBodyPart("file", new File(file));
            entity.bodyPart(filePart);
        }
    }
}