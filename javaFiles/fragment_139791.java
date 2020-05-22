@RunWith(MockitoJUnitRunner.class)
public class MetricsRecorderTest {

    @Test
    public void metricsRecorderTest() {
        StatsDClient dClientMock = Mockito.mock(StatsDClient.class);
        MetricRecorder recorder = new MetricRecorder("dev", dClientMock);
        recorder.inc("foo", 1);
        verify(recorder.metrics).recordHistogramValue(eq("dev.foo"), 1);
    }
}