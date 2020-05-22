public static void main(String[] args) {

    Float x = 1.0f;
    final Optional<Float> input = Optional.of(x);
    Optional<Float> output = firstPresent(input, (a) -> a.map(FUNCTION1).map(FUNCTION2),
                                     (a) -> a.map(FUNCTION3).map(FUNCTION4),
                                     (a) -> a.map(FUNCTION5).map(FUNCTION6));
}

@SafeVarargs
public static <I,O> Optional<O> firstPresent(Optional<I> input, Function<Optional<I>, Optional<O>>... functions) {
    for (Function<Optional<I>, Optional<O>> function : functions) {
        final Optional<O> output = function.apply(input);
        if(output.isPresent()) {
            return output;
        }
    }
    return Optional.empty();
}