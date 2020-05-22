<T> List<T> getElementsOf(Class<T> clazz) {
    return list.stream()
            .filter(clazz::isInstance)
            .map(clazz::cast)
            .collect(toList());
}