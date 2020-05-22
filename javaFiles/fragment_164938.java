import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONObject;

@Path("/test")
public class ProjectInfo {      
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String submitProject(JSONObject obj) {  
        //read the json object data and insert the content to DB.
        //generate the response you like and return it
        //ObjectMapper class from codehaus can be used to generated desired json response.
        return generatedJSONResponse;
    }
}