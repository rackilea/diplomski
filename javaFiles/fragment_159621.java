Test test = new Test();

test.property1 = "some value";

HashMap<String, Integer> map = new HashMap<>();
map.put("one", 1);
map.put("fourty two", 42);
test.property2.put("property2-key", map);

ArrayList<String> strings = new ArrayList<>(Arrays.asList("string1",
            "string2", "string3"));
test.property3.put("property3-key", strings);

String[] stringArray = { "array1", "array2", "array3" };
test.property4.put("property4-key", stringArray);

Gson gson = new Gson();
String json = gson.toJson(test);
System.out.println(json);