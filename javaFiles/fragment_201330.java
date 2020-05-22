public class MonitorTest {
  @MockBean
  private IMonospaceNotifier notifier;

  @Test
  public void doNothing(){
    doReturn(SOME_TEST_REPORT_STRING).when(notifier).monospace(anyString());
  // ...