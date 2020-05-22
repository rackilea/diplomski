import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class TestClass {
    @Rule
    public WireMockRule serviceA = new WireMockRule(WireMockConfiguration.options().dynamicPort());

    @Before
    public void before() {
        serviceA.stubFor(get(urlPathEqualTo("/test-path/test")).willReturn(aResponse()
            .withHeader("Content-Type", "application/json").withStatus(200).withBody("serviceA:test-path")));
    }

    @Test
    public void testRoute() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/test-path/test", String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        serviceA.verify(1, getRequestedFor(urlPathEqualTo("/test-path/test")));
    }
}