final Pattern pattern = Pattern.compile("\\$(?<key>[^=]++)=\\{(?<value>[^}]++)\\}");
final String input = "$key1={331015EA261D38A7}\n$key2={9145A98BA37617DE}\n$key3={EF745F23AA67243D}";
final Matcher matcher = pattern.matcher(input);
final Map<String, String> parse = new HashMap<>();
while (matcher.find()) {
    parse.put(matcher.group("key"), matcher.group("value"));
}
//print values
parse.forEach((k, v) -> System.out.printf("Key '%s' has value '%s'%n", k, v));