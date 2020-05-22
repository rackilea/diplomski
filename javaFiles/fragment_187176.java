@PostMapping("/reverse")
public String reverseList(@RequestBody String string) {
    List<String> stringList = Arrays.asList(string.split("[+,]"));
    return  IntStream.range(0, stringList.size())
            .mapToObj(i -> stringList.get(stringList.size() - 1 - i))
            .collect(Collectors.joining("+"));
}