public static <T, U, TCollection extends Collection<T>, 
                UCollection extends Collection<U>>
    UCollection MappedCollection(TCollection collection, 
                                 Function<T, U> function,
                                 Supplier<UCollection> uCollectionSupplier) {

    return MappedStream(collection.stream(), function)
           .collect(Collectors.toCollection(uCollectionSupplier));
}