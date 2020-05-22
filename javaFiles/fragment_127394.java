public class MControllerTest {

    private MockMvc mockMvc;

    @InjectMocks A a;
    @InjectMocks B b;
    @InjectMocks AController aController;

    @Autowired WebApplicationContext webApplicationContext;
    @Autowired private FilterChainProxy springSecurityFilterChain;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                 .addFilter(springSecurityFilterChain)
                                 .build();
    }

    @Test
    public void postMovieTest() throws Exception {

        a.setDDDD("XXX");
        b.setCCCC;
        a.setMList(Arrays.asList(b));


        mockMvc.perform(post("/path")
            .content(asJsonString(a))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
    }