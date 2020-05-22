// Variant 1: Nested for-each
result.forEach(message -> message.forEach(System.out::println));

// Variant 2: Flat-map
result.stream().flatMap(List::stream).forEach(System.out::println));

// Variant 3: Without streams
for (List<String> message : result) {
    for (String line : message) {
        System.out.println(line);
    }
}