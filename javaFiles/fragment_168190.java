@Replaces(Dependency.class)
@Singleton
public class MockDependency extends Dependency {

    private final Dependency delegate;

    public MockDependency() {
        this.delegate = mock(Dependency.class);
    }

    @Override
    void run() {
        delegate.run();
    }
}