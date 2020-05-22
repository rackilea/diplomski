@Autowired
private WebApplicationContext context;

@Autowired
private Filter springSecurityFilterChain;

@Before
public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context)
            .addFilters(springSecurityFilterChain).build();
}