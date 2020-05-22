Function<Entry<String, List<MyClass>>, List<MyClass>> filterBy(final Color color) {
    return e -> e.getValue()
                 .stream()
                 .filter(s -> s.getColor() == color)
                 .collect(toList());
}