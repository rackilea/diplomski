@RunWith(MockitoJUnitRunner.class)
public class PostDataTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private Environment env;

    @InjectMocks
    private PostData postData;

    @Test
    public void test_postJSONData() {
        String baseUrl = "theBaseUrl";
        String resourcePath = "aResourcePath";

        Mockito.when(env.getProperty("baseURL")).thenReturn(baseUrl);
        Mockito.when(env.getProperty("resourcePath")).thenReturn(resourcePath);

        List<String> payload = new ArrayList<>();

        postData.postJSONData(payload);

        // it's unclear from your posted code what goes into the HttpEntity so
        // this approach is lenient about its expectation
        Mockito.verify(restTemplate).postForObject(
                Mockito.eq(baseUrl + resourcePath),
                Mockito.any(HttpEntity.class),
                Mockito.eq(String.class)
        );

        // assuming that the HttpEntity is constructed from the payload passed 
        // into postJSONData then this approach is more specific
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        Mockito.verify(restTemplate).postForObject(
                Mockito.eq(baseUrl + resourcePath),
                Mockito.eq(new HttpEntity<>(payload.toString(), headers)),
                Mockito.eq(String.class)
        );
    }
}