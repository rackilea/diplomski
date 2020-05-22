Map<String, String> map = new TreeMap<>();
map.put("foo", null);
map.put("bar", null);
map.put("foo1", null);
map.put("bar1", null);

Yaml yaml = new Yaml();
String output = yaml.dumpAsMap(map); // yaml.dump(map);
System.out.println("---");
System.out.println(output.replace("null", "~"));