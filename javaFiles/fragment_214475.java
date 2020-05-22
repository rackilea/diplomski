return reduce(list, (acc, element) -> {
    if (!acc.contains(element)) {
        acc.add(element);
    }
    return acc;
});