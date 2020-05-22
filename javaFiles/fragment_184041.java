@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@WebIntegrationTest
public class IntegrationTest {

    @Value("${local.server.port}")
    int port;

    final RestTemplate template = new RestTemplate();

    @Test
    public void testGetListResponse() {
        String url = "http://localhost:" + port + "/test";
        ResponseEntity<List<String>> response = template.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});
        List<String> list = response.getBody();
        Assert.assertEquals(list.size(), 1);
        Assert.assertEquals(list.get(0), "test");
    }

    @Test
    public void testGetErrorResponse() {
        String url = "http://localhost:" + port + "/test?error=true";
        String errorBody = null;
        try {
            ResponseEntity<List<String>> response = template.exchange(
                    url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
                    });
        } catch (HttpStatusCodeException e) {
            errorBody = e.getResponseBodyAsString();
        }
        Assert.assertEquals(errorBody, "Exception Message");
    }
}