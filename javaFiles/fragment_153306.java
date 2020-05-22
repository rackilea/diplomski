@RunWith(MockitoJUnitRunner.class)
public class MyTestClass
{
    private static final String DOMAIN = "mock";

    @Mock 
    private TransactionManager transactionManager;

    @Mock 
    private SearchManager searchManager;

    private Filter filter;

    @Before
    public void setup() throws Exception {
        filter = new Filter(transactionManager, searchManager, DOMAIN);
    }

    @Test
    public void myTest() throws Exception {
        filter.callMethod(); // No more NPE
    }
}