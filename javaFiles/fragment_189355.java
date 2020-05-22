@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // or @ContextConfiguration
public class HomeControllerTest{

    @Autowired
    private HomeController homeController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        // Setup Spring test in standalone mode
        this.mockMvc = 
          MockMvcBuilders.standaloneSetup(homeController).build();
    }