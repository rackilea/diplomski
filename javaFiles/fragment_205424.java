@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExampleResourceTest {

    @LocalServerPort
    private int port;

    private Client client = ClientBuilder.newClient();


    @Test
    public void testCustomerLocationOnPost() {
        Customer customer = new Customer("Jane", "Doe");

        URI resourceUri = UriBuilder.fromUri("http://localhost")
                .port(port).path("api").path("customers").build();

        Response response = client.target(resourceUri).request().post(Entity.json(customer));

        // test that we get the correct status code
        assertThat(response.getStatus())
                .isEqualTo(Response.Status.CREATED.getStatusCode());

        // test that the location header is correct.
        assertThat(response.getHeaderString(HttpHeaders.LOCATION))
                .isEqualTo(UriBuilder.fromUri(resourceUri).path("123").build().toString());
    }
}