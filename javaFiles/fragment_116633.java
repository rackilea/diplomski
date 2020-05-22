public static List<String> replace(Collection<String> attributes, String value, Collection<String> additionalValues) {
    return attributes.stream()
                     .map(val -> value.equals(val) ? additionalValues.stream() : Stream.of(val))
                     .flatMap(Function.identity())
                     .collect(Collectors.toList());
}