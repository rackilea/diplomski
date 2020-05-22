@RunWith(MockitoJUnitRunner.class)
public class PortfolieTest {

    @InjectMocks
    Portfolio portfolio = new PortfolioImpl();

    @Mock
    private thePortType port;

    @Mock    
    private WSHelper wsHelper = new WSHelper();

    @Before
    public void setup() throws Feil, MalformedURLException, DocumentException {

        RESPONSE response = new RESPONSE();
        …

        when(wsHelper.gePort(someParameters).thenReturn(port);
        when(port.wsmethod(any(REQUEST.class))).thenReturn(response);

    }

    @Test
    public void update() throws MalformedURLException, DocumentException {
        assertEquals(true, portfolio.update(someParameters));
    }