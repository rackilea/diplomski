@Path("hello")
public static class HelloResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String doPost(Map<String, String> data) {
        return "Hello " + data.get("name") + "!";
    }

}

@Override
protected Application configure() {
    return new ResourceConfig(HelloResource.class);
}

@Test
public void testPost() {
    Map<String, String> data = new HashMap<String, String>();
    data.put("name", "popovitsj");

    final String hello = target("hello")
            .request()
            .post(Entity.json(data), String.class);

    assertEquals("Hello popovitsj!", hello);
}