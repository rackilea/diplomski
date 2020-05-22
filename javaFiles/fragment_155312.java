List<String> index = Arrays.asList("This", "an", "example");
String x = "This is an example string!";
for (String str : index) {
  x = x.replace(str, "*");
}
System.out.println(x);