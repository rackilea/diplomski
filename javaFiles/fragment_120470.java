String[] data = { "foo", "bar" };
List<String> values = Arrays.asList(data);
System.err.println(values); // [foo, bar]
data[0] = "buzz";
values.set(1, "quak");
System.err.println(values); // [buzz, quak]
System.err.println(Arrays.toString(data)); // [buzz, quak]