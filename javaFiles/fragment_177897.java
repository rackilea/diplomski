@Path("/")
public class ServerResource {
    @GET
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public MainView getMainView(@HeaderParam("X-Requested-With") String requestType) {
        if(requestType != null && requestType.equals("XMLHttpRequest")) {
           //The request is AJAX
        } else {
           //The request is not AJAX
        }
        ...
    }
}