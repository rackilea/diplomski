@RunWith(SpringRunner.class)
@SpringBootTest
public class FooServiceTests {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FooService fooService; // Your service

    private MockRestServiceServer server;

    @Before
    public void setUp() {
        server = MockRestServiceServer.bindTo(restTemplate).build();
    }
}