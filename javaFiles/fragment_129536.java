public class MyCustomFilterPredicate implements Predicate<Object> {
    private final Closure closure;
    public MyCustomFilterPredicate(final Closure closure) {
        this.closure = closure;
    }
    @Override
    public boolean test(final Object o)
    {
        return (boolean) closure.execute(JexlEngine.getThreadContext(), o);
    }
}

public class MyCustomMapFunction implements Function<Object, Object> {
    private final Closure closure;
    public MyCustomMapFunction(final Closure closure) {
        this.closure = closure;
    }
    @Override
    public Object apply(final Object o)
    {
        return closure.execute(JexlEngine.getThreadContext(), o);
    }
}