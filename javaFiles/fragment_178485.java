Map<String, Integer> m1 = new LinkedHashMap<>();
m1.put("one", 1);
m1.put("two", 2);
m1.put("three", 3);

Set<Map.Entry<String, Integer>> sme1 = m1.entrySet();
System.out.println(sme1);

sme1.remove(new AbstractMap.SimpleEntry<String, Integer>("one",1));

System.out.println(sme1);