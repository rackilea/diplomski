@ContextConfiguration(locations = "classpath:/META-INF/spring-test/tests-context.xml") 
@RunWith(SpringJUnit4ClassRunner.class) 
@TestExecutionListeners(TransactionContextTestExecutionListener.class) 
@Transactional 
public class BaseQueryBuilderTest {
    @Autowired
    private ApplicationContext applicationContext;
    protected Context context;

    @Before
    public void setUp() {
        context = applicationContext.getBean(Context.class);
    }
}