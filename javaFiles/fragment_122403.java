@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MySpringApplication.class})
@WebAppConfiguration
public myTestClass {
    MockMvc mockMvc;

    @Autowired
    ItemDAO itemDAO;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
        itemDAO.deleteAll();
    }

    @Test
    public void testMethod() {
        // DB init by saving objects: create a item and save it via DAO, use real test DB

        // Only mocking about rest call:
        String res = mockMvc.perform(get("/items")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    }