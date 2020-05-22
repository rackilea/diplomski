Map<String, Integer> m1 = new LinkedHashMap<>();
m1.put("one", 1);
m1.put("two", 2);
m1.put("three", 3);

System.out.println(m1);

m1.remove("one");

System.out.println(m1);