@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/test-application-context.xml" })
public class PeopleListBeanTest {

    @Autowired
    private PeopleListBean peopleListBean;
    @Autowired
    private PersonRepository mockPersonRepository;

    @BeforeClass
    public static void initialise() {

    }

    // .
    // .
    // .
}