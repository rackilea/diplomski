Trade trade = Optional.ofNullable(id)
    .stream() // <-- Stream either empty or with the id
    .map(service::findTrades) // <-- Now we are at the stream pipeline
    .flatMap(Collection::stream) // We need to flatmap, so that we
    .filter(Objects::nonNull)    // stream the elements of the collection
    .findFirst()
    .orElse(... default value...);