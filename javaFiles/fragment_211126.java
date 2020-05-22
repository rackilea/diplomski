// set up the runner so Mockito handles all the 
// initialization and injections
@RunWith(MockitoJUnitRunner.class)
public class Testing {

    // HttpHeaders is mocked and injected into test
    @Mock
    private HttpHeaders headers;

    // HttpHeaders is injected into the resource class field
    @InjectMocks
    private TestResource resource;

    @Test
    public void testHttpHeaders() {
        // control what the mock returns when certain methods are called
        when(headers.getHeaderString("X-Test")).thenReturn("X-Test-Value");
    }
}