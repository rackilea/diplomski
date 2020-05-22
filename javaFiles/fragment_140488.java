@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    private MockMvc mockMvc;
    private static LoginController loginController;

    @Mock
    private StaffService staffService;

    @Before
    public void setUp() {
        loginController = new LoginController(staffService);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).setViewResolvers(viewResolver).build();
     }

      @Test
      public void testShowLoginPage() throws Exception {
         mockMvc.perform(get("/")).andExpect(view().name("login"));
      }
}