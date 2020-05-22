import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.core.header.ContentDisposition;
import com.sun.jersey.core.util.ReaderWriter;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import com.sun.jersey.spi.container.servlet.WebComponent;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Run this like any other JUnit test. Dependencies for test are as follows.
 * 
 * <jersey.version>1.19</jersey.version>
 * 
 * <dependency>
 *    <groupId>com.sun.jersey</groupId>
 *    <artifactId>jersey-servlet</artifactId>
 *    <version>${jersey.version}</version>
 * </dependency>
 * <dependency>
 *    <groupId>com.sun.jersey</groupId>
 *    <artifactId>jersey-servlet</artifactId>
 *    <version>${jersey.version}</version>
 * </dependency>
 * <dependency>
 *    <groupId>com.sun.jersey.jersey-test-framework</groupId>
 *    <artifactId>jersey-test-framework-grizzly2</artifactId>
 *    <version>1.19</version>
 *    <scope>test</scope>
 * </dependency>
 * <dependency>
 *    <groupId>com.sun.jersey.contribs</groupId>
 *    <artifactId>jersey-multipart</artifactId>
 *    <version>${jersey.version}</version>
 * </dependency>
 * 
 */
public class MultipartTest extends JerseyTest {


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

    public static class AppConfig extends DefaultResourceConfig {
        public AppConfig() {
            super(Service.class);
        }
    }

    @Override
    public WebAppDescriptor configure() {
        return new WebAppDescriptor.Builder()
                .initParam(WebComponent.RESOURCE_CONFIG_CLASS, 
                           AppConfig.class.getName())
                .build();
    }

    private static final String FILE_ONE = "<enter-a-file-path>";
    private static final String FILE_TWO = "<enter-a-file-path>";

    @Test
    public void doit() {
        File file1 = new File(FILE_ONE);
        File file2 = new File(FILE_TWO);
        MultiPart entity = new FormDataMultiPart();
        FileDataBodyPart filePart = new FileDataBodyPart("file", file1);
        entity.bodyPart(filePart);
        filePart = new FileDataBodyPart("file", file2);
        entity.bodyPart(filePart);

        ClientResponse response = resource().path("service")
                .type(MediaType.MULTIPART_FORM_DATA_TYPE)
                .post(ClientResponse.class, entity);
        assertEquals(200, response.getStatus());
        assertEquals("Upload OK", response.getEntity(String.class));
        response.close();
    }
}