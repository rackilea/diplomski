public class DummyWrappedContext implements WrapperContext {

    private final Context wrappedContext;

    public DummyWrapperContext(Context wrappedContext) {
        this.wrappedContext = wrappedContext;
    }

    @Override
    public Context getWrappedContext() {
        return this.wrappedContext;
    }

    // TODO other methods from Context, etc.
}