public class MyControllerTest {

    @InjectMocks
    private MyController myController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(MyController)
                .build();

    }

    @Test
    public void addLocation_StatusOK() throws Exception {
        this.mockMvc.perform(
                post("/addLocation")
                        .param("plz_ort", "PLZ ORT")
                        .param("umkreis", "5")
                        .sessionAttr("queryTopics", new ArrayList<String>(0))
                .andExpect(
                        status().isOk());
    }
}