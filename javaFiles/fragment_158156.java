public static List<String> catch22(List<String> input) {
    if (input == null) return null;
    return input.stream().collect(Collectors.toList());
    // Or this. B'coz this is really what your code is doing.
    return new ArrayList<>(input);
}