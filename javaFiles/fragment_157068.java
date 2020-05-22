@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
@SpringApplicationConfiguration(classes = SampleDataJpaApplication.class)
public class MyTest {
    @Value("${local.server.port}")
    int port;

    RestTemplate template = new TestRestTemplate();

    @Test
    public void testRequest() throws Exception {
        template.getForEntity("http://localhost:" + port + "/rest/path/dosomething", String.class);
        // Somehow verify that your application did the right thing, e.g. because some mocked component was called or the system is in a certain state.
    }
}