public <T> void set (byte [] value, 
                     Consumer<T> setter, 
                     Function<byte[],T> transformer) {
    T transformedValue = transformer.apply(value);
    setter.accept(transformedValue);
}