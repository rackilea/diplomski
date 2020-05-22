String input = "1 2 lucky 4 buzz fizz";
Map<String, Long> map = Pattern.compile(" ").splitAsStream(input)
        .collect(groupingBy(s -> (Character.isDigit(s.charAt(0)) ? "integer" : s), counting()));
List.of("fizz", "buzz", "fizzbuzz", "lucky", "integer")
    .forEach(s -> map.putIfAbsent(s, 0L));
String output = map.entrySet().stream()
                   .map(e -> e.getKey() + ": " + e.getValue())
                   .collect(Collectors.joining(" "));
System.out.println(output);