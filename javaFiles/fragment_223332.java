@Path("/resource")
@Produces({ "application/xml"})
public class ResourceAPI{

    @GET
    @Path("/childs")
    @Produces("application/xml")
    public GetChildsResp
            getChilds(){

        GetChildsResp response = new GetChildsResp();

        // build and populate response with all the Childs (from your DB)

        return response;

    }

}