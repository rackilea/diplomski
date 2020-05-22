String[] strings = {"a", "b", "c"};
List<String> list = Arrays.asList(strings);
System.out.println(list.get(0)); // "a"
strings[0] = "d";
System.out.println(list.get(0)); // "d"
list.set(0, "e");
System.out.println(strings[0]); // "e"