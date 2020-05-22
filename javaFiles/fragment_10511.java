List<String> input = new ArrayList<>();
input.add("1");
input.add("2");
input.add("3");

final String result = Joiner.on(delimiter).join(input);
System.out.println(result);
// Results in output: 1,2,3