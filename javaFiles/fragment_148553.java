@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JasperClientTest {

    @Value("${jasper.baseUri}")
    private String jasperBaseURI;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private JasperClient jasperClient;

    private MockRestServiceServer mockRestServiceServer;

    @Before
    public void setUp() {
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void sendRequest() {

        String detailsString ="{message : 'under construction'}";

        String externalId = "89610185002142494052";
        String uri = jasperBaseURI +  "/devices/" + externalId + "/smsMessages";

        mockRestServiceServer.expect(requestTo(uri)).andExpect(method(POST))
                .andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON));

        boolean isSentSuccessfully = jasperClient.sendRequest(externalId);
        assertTrue(isSentSuccessfully);
    }
}