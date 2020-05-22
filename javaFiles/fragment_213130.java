import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class FileUpload {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("fileupload")
    public Response doUpload(@Context HttpServletRequest request) {
        JsonArrayBuilder array = Json.createArrayBuilder();

        try {
            for (Part part : request.getParts()) {
                String name = null;
                long size = 0;
                try {
                    if (part.getContentType() == null
                            || !part.getContentType().toLowerCase()
                                    .startsWith("image/"))
                        continue;

                    name = part.getSubmittedFileName();
                    size = part.getSize();

                    array.add(addFile(name, size, "anId"));
                    part.delete();
                } catch (Exception e) {
                    array.add(addError(name, size, "ERROR"));
                }
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

        JsonObject ret = Json.createObjectBuilder().add("files", array).build();
        return Response.status(201).entity(ret).build();
    }

    private JsonObjectBuilder addFile(String name, long size, String url) {
        return Json.createObjectBuilder().add("name", name).add("size", size)
                .add("lid", url);
    }

    private JsonObjectBuilder addError(String name, long size, String error) {
        return Json.createObjectBuilder().add("name", name).add("size", size)
                .add("error", error);
    }

}