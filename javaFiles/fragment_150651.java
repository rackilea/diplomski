Multimap<String, String> values = HashMultimap.create();
values.put("user1", "value1");
values.put("user2", "value2");
values.put("user3", "value3");
values.put("user1", "value4");

System.out.println(values.get("user1"));
System.out.println(values.get("user2"));
System.out.println(values.get("user3"));