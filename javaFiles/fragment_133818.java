public class DummyWrapperAction implements Action<WrapperContext> {

    private final Action wrappedAction;

    public DummyWrapperAction(Action wrappedAction) {
        this.wrappedAction = wrappedAction;
    }

    @Override
    public void resolve(WrapperContext context) {
        System.out.println("Before");
        Context wrappedContext = context.getWrappedContext();
        wrappedAction.resolve(wrappedContext);
        System.out.println("After");
    }
}