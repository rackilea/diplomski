public class Combiner<R> {

    private Object input;

    public Combiner(Object input) {
        this.input = input;
    }

    @SuppressWarnings("unchecked")
    @SafeVarargs
    public final R combineFunctions(Function<Object, Object>... functions) {
        return (R) Arrays.stream(functions)
                         .reduce(Function::andThen)
                         .orElseThrow(() -> new IllegalArgumentException("No functions to combine"))
                         .apply(input);
    }

}