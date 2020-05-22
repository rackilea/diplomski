@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeClientTest {
    @Autowired
    private SomeClient someClient;

    private MockWebServiceServer mockWebServiceServer;

    @Before
    public void setUp() {
        mockWebServiceServer = MockWebServiceServer.createServer(someClient);
    }

    @Test
    public void fourHitsMethodTest() {     
        //mocks only the 1st, but not the 3rd response
        mockWebServiceServer
        .expect(payload(getUrlRequest()))
        .andRespond(withPayload(getUrlResponse()));
        //mocks the 2nd response
        mockWebServiceServer
        .expect(payload(getEmployeesPermissionRequest()))
        .andRespond(withPayload(getEmployeesPermissionResponse()));
        //mocks the 3rd response
        mockWebServiceServer
        .expect(payload(getUrlRequest()))
        .andRespond(withPayload(getUrlResponse()));
        //mocks the 4th response
        mockWebServiceServer
        .expect(payload(doSomeStaffRequest()))
        .andRespond(withPayload(doSomeStaffResponse()));
        //those 4 hits are been performed in fourHitsMethod()
        assertNotNull(someClient.fourHitsMethod("foo", "bar"));
        mockWebServiceServer.verify();
    }
}