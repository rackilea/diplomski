@RunWith(MockitoJUnitRunner.class)
public class CompletableFutureServiceTest {

    // The mock of my service A
    @Mock
    private ServiceA ServiceA;
    // The mock of my service B
    @Mock
    private ServiceB ServiceB;
    // The mock of your executor for the service A
    @Mock
    private Executor serviceAExecutorService;
    // The mock of your executor for the service B
    @Mock
    private Executor serviceBExecutorService;
    // My class in which I want to inject the mocks
    @InjectMocks
    private CompletableFutureService service;

    @Test
    public void testSomeMethod() {
        // Mock the method execute to call the run method of the provided Runnable
        doAnswer(
            (InvocationOnMock invocation) -> {
                ((Runnable) invocation.getArguments()[0]).run();
                return null;
            }
        ).when(serviceAExecutorService).execute(any(Runnable.class));
        doAnswer(
            (InvocationOnMock invocation) -> {
                ((Runnable) invocation.getArguments()[0]).run();
                return null;
            }
        ).when(serviceBExecutorService).execute(any(Runnable.class));

        ServiceAResponse serviceAResponse = ... // The answer to return by service A
        // Make the mock of my service A return my answer
        when(ServiceA.retrieve(any(ServiceARequest.class))).thenReturn(
            serviceAResponse
        );
        ServiceBResponse serviceBResponse = ... // The answer to return by service B
        // Make the mock of my service B return my answer
        when(ServiceB.retrieve(any(ServiceBRequest.class))).thenReturn(
            serviceBResponse
        );

        // Execute my method
        ServiceResponse response = service.someMethod(
            new ServiceARequest(), new ServiceBRequest()
        );

        // Test the result assuming that both responses are wrapped into a POJO
        Assert.assertEquals(serviceAResponse, response.getServiceAResponse());
        Assert.assertEquals(serviceBResponse, response.getServiceBResponse());
    }
}