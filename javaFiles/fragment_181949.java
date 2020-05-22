@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("servlet-context.xml")
public class SampleTests {

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = webAppContextSetup(this.wac).build();
  }

  @Test
  public void getFoo() throws Exception {
    this.mockMvc.perform(get("/foo").accept("application/json"))
        .andExpect(status().isOk())
        .andExpect(content().mimeType("application/json"))
        .andExpect(jsonPath("$.name").value("Lee"));
  }}