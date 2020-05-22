@RunWith(JMockit.class)
public class ResultGeneratorTest {
    // Synchronous invocation, mocked AsyncLauncher
    @Test
    public void testGetResultAsync(@Mocked final ResultSignal resultSignal, @Mocked final Result result) throws Exception {
        new MockUp<AsyncLauncher>() {
            @Mock
            void getResult(FutureCallback<Result> futureCallback) {
                futureCallback.onSuccess(result);
            }
        };
        ResultGenerator resultGenerator = new ResultGenerator();
        resultGenerator.getResultAsync(resultSignal);
        new Verifications() {{
            resultSignal.success((Result) any); times = 1;
            resultSignal.failure(); times = 0;
        }};
    }

    // Asynchronous invocation, real AsyncLauncher in use
    @Test
    public void testGetResultAsyncDelayed(@Mocked final Result result) throws Exception {
        final AtomicBoolean latch = new AtomicBoolean(false);
        MockUp<ResultSignal> resultSignalMockUp = new MockUp<ResultSignal>() {
            @Mock(invocations = 1)
            public void success(Result result) {
                latch.set(true);
            }

            @Mock(invocations = 0)
            public void failure() {
                latch.set(true);
            }
        };
        ResultGenerator resultGenerator = new ResultGenerator();
        final ResultSignal resultSignal = resultSignalMockUp.getMockInstance();
        resultGenerator.getResultAsync(resultSignal);
        Awaitility.await().untilTrue(latch);
    }

}