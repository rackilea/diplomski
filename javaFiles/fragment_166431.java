public class OptionalParamTest extends JerseyTest {

    @Path("optional")
    public static class Resource {
        @GET
        @Path("/method{noop: (/)?}{id: ((?<=/)\\d+)?}")
        public String get(@PathParam("id") int id) {
            return String.valueOf(id);
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(Resource.class);
    }

    @Test
    public void should_return_id_1() {
        Response response = target("optional/method/1").request().get();
        System.out.println("status=" + response.getStatus());
        assertEquals("1", response.readEntity(String.class));
    }

    @Test
    public void should_return_id_0_with_no_id() {
        Response response = target("optional/method").request().get();
        assertEquals(200, response.getStatus());
        assertEquals("0", response.readEntity(String.class));
    }

    @Test
    public void should_return_404_with_numbers_and_no_slash() {
        Response response = target("optional/method12").request().get();
        assertEquals(404, response.getStatus());
    } 

    @Test
    public void should_return_404_with_numbers_and_letters() {
        Response response = target("optional/method/12b").request().get();
        assertEquals(404, response.getStatus());
    }

    @Test
    public void should_return_404_with_only_letters() {
        Response response = target("optional/method/ab").request().get();
        assertEquals(404, response.getStatus());
    } 
}