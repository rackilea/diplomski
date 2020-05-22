Set<Property> properties = new HashSet<>();
    properties.add(new Property("0", "a", "A"));
    properties.add(new Property("1", "b", "B"));
    Map<String, String> result = properties.stream()
        .collect(Collectors.toMap(p -> p.key, p -> p.value));
    System.out.println(result);