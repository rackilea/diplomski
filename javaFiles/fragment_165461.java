public class MockServiceTest extends JerseyTest  {

    public static interface Service {
        String getMessage(String name);
    }

    @Path("message")
    public static class MessageResource {

        private final Service service;

        public MessageResource(Service service) {
            this.service = service;
        }

        @GET
        public String get(@QueryParam("name") String name,
                          @Context HttpHeaders headers,
                          @Context UriInfo uriInfo) {
            String nameQuery = uriInfo.getQueryParameters().getFirst("name");
            String header = headers.getHeaderString("X-Header");
            assertNotNull(nameQuery);
            assertNotNull(header);
            return service.getMessage(name);
        }
    }

    private Service service;

    @Override
    public ResourceConfig configure() {
        service = Mockito.mock(Service.class);
        return new ResourceConfig().register(new MessageResource(service));
    }

    @Test
    public void testIt() {
        Mockito.when(service.getMessage("peeskillet")).thenReturn("Hello peeskillet");

        Response response = target("message").queryParam("name", "peeskillet").request()
                .header("X-Header", "blah")
                .get();
        assertEquals(200, response.getStatus());
        assertEquals("Hello peeskillet", response.readEntity(String.class));
    }
}