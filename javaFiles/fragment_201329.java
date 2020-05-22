public class MonitorTest {
  @MockBean
  private IMonospaceNotifier notifier;

  @Test
  public void doNothing(){
    doAnswer((invocation)-> invocation.getArguments()[0]).when(notifier).monospace(anyString());
  // ...