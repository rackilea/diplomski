@Before
public void setup() {
    dashboardController = new DashboardController(myService);
    mockMvc = MockMvcBuilders
            .standaloneSetup(dashboardController)
            .build();
}