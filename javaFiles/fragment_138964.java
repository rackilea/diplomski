@RunWith(SpringRunner.class)
@SpringBootTest
public class YourApplicationTests {
    static WireMockServer mockHttpServer = new WireMockServer(10000); // endpoint port here

    @BeforeClass
    public static void setup() throws Exception {
        mockHttpServer.stubFor(get(urlPathMatching("/")).willReturn(aResponse().withBody("test").withStatus(200)));
        mockHttpServer.start();
    }

    @AfterClass
    public static void teardown() throws Exception {
        mockHttpServer.stop();
    }

    @Test
    public void someTest() throws Exception {
        // your test code here
    }
}