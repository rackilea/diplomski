@ContextConfiguration(classes = MyConfiguration.class})
    @RunWith(SpringJUnit4ClassRunner.class)
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @TestExecutionListeners( { WebContextTestExecutionListener.class})
    public class UserSpringIntegrationTest {

    @Autowired
    private UserBean userBean;

    //All the test methods
    }