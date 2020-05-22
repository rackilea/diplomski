public static <T, U, C extends Collection<U>> 
    C mappedCollection(Collection<T> collection, 
                       Function<T, U> function,
                       Supplier<C> collectionSupplier) {
    return MappedStream(collection.stream(), function)
           .collect(Collectors.toCollection(collectionSupplier));
}