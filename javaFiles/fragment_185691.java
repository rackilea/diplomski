@Autowired
private WebApplicationContext wac;

private MockMvc mockMvc;

@Before
public void setUp() {
   Collection<Filter> filterCollection = wac.getBeansOfType(Filter.class).values();
   Filter[] filters = filterCollection.toArray(new Filter[filterCollection.size()]);
   mockMvc = MockMvcBuilders.webAppContextSetup(wac).addFilters(filters).build();
}