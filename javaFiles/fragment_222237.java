// sample input
String input = "abcd **Rid** efgh";

// a small map
Map<String, String> map = new HashMap<String, String>();
map.put("Rid","VALUE");

// the loop that replaces the **Rid** substring
for (Map.Entry<String,String> entry:map.entrySet()){
  input = input.replace("**"+entry.getKey()+"**", entry.getValue());
  System.out.println(input);
}