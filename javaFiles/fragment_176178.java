int value = 23;
List<Integer> result =
    values.stream()
        .filter(i -> i % 100 == value)
        .collect(Collectors.toList());
System.out.println(result);