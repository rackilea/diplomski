@Test
public void testResteasy() throws Exception {
    WebTarget target = client.target(
            TestPortProvider.generateURL(BASE_URI)).path("zip");


    File file = new File("C:/test/test.zip");
    Response response = target.request().post(
            Entity.entity(file, "application/zip"));

    System.out.println(response.getStatus());
    System.out.println(response.readEntity(String.class));
    response.close();

    file = new File("C:/test/test1.xml");
    response = target.request().post(
            Entity.entity(file, "application/xml"));

    System.out.println(response.getStatus());
    System.out.println(response.readEntity(String.class));
    response.close();

}