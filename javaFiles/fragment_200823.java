Trade trade = Optional.ofNullable(id)
    .map(service::findTrades)
    .map(Collection::stream)
    .orElse(Stream.empty()) // or orElseGet(Stream::empty)
    .filter(Objects::nonNull)
    .findFirst()
    .orElse(... default value...);