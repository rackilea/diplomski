@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;


    private UserService userService;
    private User user;

    @Before
    public void setUp() throws Exception {
       userService = new UserService(userRepository);
    }

    @Test
    public void tesGetUserIdStatus() {
        //your test code
    }