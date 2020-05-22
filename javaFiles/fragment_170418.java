BigDecimal total = keys_to_add.stream()
        .filter(map::containsKey)
        .map(map::get)
        .map(Map::values)
        .flatMap(Collection::stream)
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);