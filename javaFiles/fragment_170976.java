import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public Response getFile(String contentType) {

        File f = new File("/tmp/file.doc");

        ResponseBuilder response = Response.ok(f);
        response.type(contentType);
        response.header("Content-Disposition", "attachment; filename=\"file.doc\"");
        return response.build();
    }