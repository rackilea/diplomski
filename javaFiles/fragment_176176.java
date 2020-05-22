System.out.println(
    values.stream()
        .map(i -> Integer.toString(i))
        .filter(s -> s.endsWith(suffix))
        .collect(Collectors.joining(", "))
);