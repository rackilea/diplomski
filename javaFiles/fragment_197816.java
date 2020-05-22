package upload;
import java.io.*;
import java.nio.file.*; 
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.multipart.*; 

public class UploadResource {

    @POST
    @Path("/upload")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String uploadFile(@Multipart("note") String note, 
     @Multipart("upfile") Attachment attachment) throws IOException {

       String filename = attachment.getContentDisposition().getParameter("filename");

        java.nio.file.Path path = Paths.get("c:/" + filename);
        Files.deleteIfExists(path);
        InputStream in = attachment.getObject(InputStream.class);

       Files.copy(in, path);
       return "uploaded " + note;  
    }                        

}