String str = "aabbcccddd";
// Convert the String into a Stream
// Convert int into Character
// Group by Character and count occurrences
// For each entry add the key (Character) followed by the value (Occurrences) to the result
// using the joining collector
String output = str.chars()
    .mapToObj(i -> (char)i)
    .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))
    .entrySet()
    .stream()
    .flatMap(entry -> Stream.of(entry.getValue().toString(), entry.getKey().toString()))
    .collect(Collectors.joining());

System.out.println(output);