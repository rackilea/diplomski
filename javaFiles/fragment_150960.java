@SpringBootTest(classes = CentralApp.class)
@ContextConfiguration
public class RefreshActiveJobsStepDefs {

  @Inject
  private SchedulerService schedulerService;

  @Mock
  private AgentRestClient agentRestClient;

  @Before
  public void setup() throws Exception {
   MockitoAnnotations.initMocks(this);
   given(agentRestClient.get(anyString())).willReturn("FINISHED");
   schedulerService.setAgentRestClient(agentRestClient);
  }
  //Skipping the actual Given-When-Then Cucumber steps...
}