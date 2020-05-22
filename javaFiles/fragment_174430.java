String s = "... content read in from file ..."
String[] pairs = s.split(","); // This would split it into sections divided by the comma, resulting in an array of Strings with elements such as "type=abc"

HashMap<String, String> map = new HashMap<String, String>();

for (String string : pairs) {
    String[] keyValue = string.split("="); // Split on the "=" of an element such as "type=abc", resulting in a String array of two elements, "type" and "abc"
    map.put(keyValue[0], keyValue[1]); // Store those values however you'd like
};