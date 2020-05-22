final Map<String, String> x = new LinkedHashMap<>(10, 0.75f, true);
x.put("a", "a");
x.put("b", "b");
System.out.println(x);
x.put("a", "a");
System.out.println(x);