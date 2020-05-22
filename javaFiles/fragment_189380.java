List<UnaryOperator<String>> cleanOps = new ArrayList<>();
cleanOps.add(String::toLowerCase);
cleanOps.add(str -> str.replaceAll(" ", ""));
List<String> data = new ArrayList<>();
data.add("John Doe");
data.add("Jane Doe");
System.out.println(cleanData(data, cleanOps));