@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ReportControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext ctx;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }

    @Test
    public void doesRecoverPercentageOfInfectedPatients() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/report/infected")
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

}