Map<String, String> key_map = new HashMap<String, String>();
String[] parts_of_string = "var=test, var2=test2".split(", ");
for(String part : parts_of_string) {
    String[] key_and_value_parts = part.split("=");
    key_map.put(key_and_value_parts[0], key_and_value_parts[1]);
    System.out.println(key_and_value_parts[0] + " <-> " + key_and_value_parts[1]);
}