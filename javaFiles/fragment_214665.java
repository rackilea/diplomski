/**
 * Rule is still needed to initialize asynchronous framework.
 */
@Rule
public WorkflowTest workflowTest = new WorkflowTest();
@Mock
private ActivitiesClient mockActivities;
@Mock
private BWorkflowClientFactory workflowFactory;


@Before
public void setUp() throws Exception {
  // set up mocks
  initMocks(this);
}

@Test
public void myTest() {
  AWorkflowImpl w = new AWorkflowImpl(workflowFactory);
  w.execute(); // whatever execute method of the workflow
}