class InputConverter<T> {
   private final T value;

    public InputConverter(T value) {
        this.value = value;
    }

    public <R> R convertBy(Function<T, R> function){
        return function.apply(value);
    }
 }