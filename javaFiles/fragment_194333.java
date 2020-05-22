@Path("/testPost")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    @POST
    public Response logEvent(TestClass c) {
        System.out.println(c.p1);

        return Response.noContent().build();
    }

    public static class TestClass {

        @JsonProperty("p1")
        public String p1;

    }
}