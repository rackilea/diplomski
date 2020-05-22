@Autowired
private WebApplicationContext webApplicationContext;

@BeforeMethod
public void init() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
}