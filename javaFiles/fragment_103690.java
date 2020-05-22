@Test
public void test() {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target("http://localhost:8080/myapp/webapi");
    WebTarget targetUpdated = target.path("/users");
    String response = targetUpdated.request("application/json").get(String.class);
    assertEquals("test", response);
}