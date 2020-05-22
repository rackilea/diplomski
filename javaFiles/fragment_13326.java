@Autowired
private WebApplicationContext wac;

@Before
public void setup() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
}