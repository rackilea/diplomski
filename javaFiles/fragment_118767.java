String a = "100.00";
String b = "10.00";
String c=  "5.00";

List<String> strings = Arrays.asList(a, b, c);
final int maxLen = strings.stream().map(String::length).reduce(Math::max).get();

strings.forEach(s -> {
    System.out.println(Stream.generate(() -> " ").limit(maxLen - s.length()).collect(Collectors.joining()) + s);
});