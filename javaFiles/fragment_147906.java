@Test
public void testResteasy() throws Exception {
    WebTarget target = client.target(
            TestPortProvider.generateURL(BASE_URI)).path("zip");
    File file = new File("C:/test/test.zip");
    Response response = target.request().post(
            Entity.entity(file, MediaType.APPLICATION_OCTET_STREAM));
    System.out.println(response.getStatus());
    System.out.println(response.readEntity(String.class));
    response.close();
}