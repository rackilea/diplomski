import org.mockito.internal.creation.CglibMockMaker;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MockHandler;
import org.mockito.listeners.InvocationListener;
import org.mockito.listeners.MethodInvocationReport;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockMaker;

public class ValidationMockMaker implements MockMaker {
    private final MockMaker delegate = new CglibMockMaker();

    public ValidationMockMaker() {
    }
    @Override
    public <T> T createMock(MockCreationSettings<T> settings, MockHandler handler) {
        settings.getInvocationListeners().add(new InvocationListener() {

            @Override
            public void reportInvocation(MethodInvocationReport methodInvocationReport) {
                Invocation invocation = (Invocation) methodInvocationReport.getInvocation();
                validateArguments(invocation.getArguments());
                validateReturnValue(methodInvocationReport.getReturnedValue());
            }
        });
        return delegate.createMock(settings, handler);
    }

    @Override
    public MockHandler getHandler(Object mock) {
        return delegate.getHandler(mock);
    }

    @Override
    public void resetMock(Object mock, MockHandler newHandler, MockCreationSettings settings) {
        delegate.resetMock(mock, newHandler, settings);
    }

    protected void validateArguments(Object... arguments) {
//        Arrays.stream(arguments).forEach(Objects::requireNonNull);
    }

    private void validateReturnValue(Object result) {
//        Objects.requireNonNull(result);
    }
}