@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes={Application.class, MvcConfig.class, SecurityConfig.class})
public class ITIndex {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @MockBean
    UserRegistrationApplicationService userRegistrationApplicationService;

    @MockBean
    UserDetailsService userDetailsService;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                        .webAppContextSetup(context)
                        .apply(springSecurity())
                        .build();
    }

    @Test
    public void should_render_index() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"))
            .andExpect(content().string(containsString("Login")));
    }
}