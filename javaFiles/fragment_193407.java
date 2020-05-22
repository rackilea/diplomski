import com.google.common.net.HttpHeaders;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/file")
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public class FileResource {

    @GET
    public Response getFile() {
        try {
            InputStream is = new FileInputStream(Paths.get("/tmp/foo.txt").toFile());
            return Response.ok(is)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"file.txt\"")
                    .build();
        } catch (FileNotFoundException ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }

    }
}