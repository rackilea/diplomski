String string = "ABBCCCD";
String[] split = string.split("");

Map<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


long result = numberOfPermutations(string.length()) / collect.values().stream().map(Main::numberOfPermutations).reduce(1L, (a, b) -> a *b);
System.out.println(result);