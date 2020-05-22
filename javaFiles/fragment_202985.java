@Path("/v1")
public interface RestApi {
    @POST
    @Path("/objects/{objectId}/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ResponseObject createObject(@PathParam("objectId") Integer objectId, RequestObject body);
}

public class RequestObject {
    public final String param1;
    public final List<Integer> param2;

    public RequestObject(String param1, List<Integer> param2) {
        this.param1 = param1;
        this.param2 = param2;
   }
}

public class ResponseObject {
    // etc
}

public static void main() {
    String url = "https://api.example.com";
    Client client = ClientBuilder.newBuilder().build().target(url);
    RestApi restApi = WebResourceFactory.newResource(RestApi.class, clientBuilder);
    ResponseObject response = restApi.createObject(12, new RequestObject("param1", ImmutableList.of(1,2,3));
}