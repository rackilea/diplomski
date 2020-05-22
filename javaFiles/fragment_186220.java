@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/FreedomSpring-servlet.xml" })
public class UserControllerTest {

@Autowired
private UserController userController;

@Inject
private ApplicationContext applicationContext;

private String jsonUser = "{ \"username\":\"jonneymendoza\",\"emailAddress\":\"jon@google.com\", \"password\":\"12345678\",\"firstName\":\"jono\", \"surname\":\"richy\", \"country\":\"united kingdom\",\"bio\":\"Bio stuff goes here about the user. where he comes from etc etc. all is well. lets go go go\" }";

@Before
public void setup() {
    assertNotNull(applicationContext);
    assertNotNull(userController);

}