public class MyTest {
  @Captor private ArgumentCaptor<Fragment> fragmentCaptor;
  @Captor private ArgumentCaptor<AppAddress> addressCaptor;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testThing() {
    IFragmentOrchestrator orchestrator = mock(IFragmentOrchestrator.class);

    // Now call some code which should interact with orchestrator 
    // TODO

    verify(orchestrator).replaceFragment(fragmentCaptor.capture(), addressCaptor.capture());

    // Now look at the captors
    // TODO
  }
}