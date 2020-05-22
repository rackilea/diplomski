public abstract class AbstractSuper {
    public final String foo() {
        // Maybe do something before calling bar...
        String initialResult = bar();
        // Do something common, e.g. validation
        return initialResult;
    }

    protected abstract String bar();
}