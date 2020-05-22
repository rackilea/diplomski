Map<String, String> keyValueMap = new HashMap<>();
keyValueMap.put("places", "to America");
keyValueMap.put("things", "events");
String input = "I want to go to {places} where {things} are happening.";
Pattern pattern = Pattern.compile("\\{(.*?)\\}");
Matcher matcher = pattern.matcher(input);
StringBuffer buffer = new StringBuffer();

while(matcher.find()) {
    matcher.appendReplacement(buffer, keyValueMap.get(matcher.group(1)));
}
matcher.appendTail(buffer);
System.out.println(buffer.toString());