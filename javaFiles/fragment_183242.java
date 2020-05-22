@RunWith(MockitoJUnitRunner.class)
public class HttpServiceTest {

    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;
    @Mock
    private RequestEntity requestEntity;

    private HttpService httpService;

    @Before
    public void setUp() {
        this.httpService = new HttpService(client);
    }

    @Test
    public void postJsonTest() {
        String path = "/a/path";
        Map<String, ?> data = new HashMap<>();

        // the postJson method features this chained call: getTarget(path).request().post(entity, Map.class)
        // so we have to mock each object created in that chain

        // covers getTarget(path)
        Mockito.when(client.target(Mockito.anyString())).thenReturn(webTarget);

        // covers request()
        Mockito.when(webTarget.request()).thenReturn(requestEntity);

        // covers post()
        Map<String, Object> expected = new HashMap<>();

        Mockito.when(requestEntity.post(Mockito.any(Entity.class), Mockito.eq(Map.class))).thenReturn(expected);
        Map<String, ?> actual = httpService.postJson(path, data);
        Assert.assertSame(expected, actual);
    }
}