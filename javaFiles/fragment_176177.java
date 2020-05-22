int value = 23;
System.out.println(
    values.stream()
        .filter(i -> i % 100 == value)
        .map(i -> Integer.toString(i))
        .collect(Collectors.joining(", "))
);