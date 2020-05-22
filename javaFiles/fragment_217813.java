private String method(String input) {
    return input.chars().boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .map(e -> Character.toString((char)e.getKey().intValue())+e.getValue())
        .collect(Collectors.joining());
}