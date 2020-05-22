public class AccountControllerITest {

    private MockMvc mvc;

    ObjectMapper om;

    @Mock
    private AccountController accountController = new AccountController();

    @InjectMocks
    private AccountService accountService = new Mockito.mock(AccountService.class);

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }