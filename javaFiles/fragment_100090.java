Map<String, String> map = new HashMap<>();
String str="ABCD 1 key1=value1 key2=value2 key3=value3";
String pattern = "\\b([^\\s]+)=([^\\s]+)\\b";

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(str);

while (m.find()) {
    System.out.println("Found a key/value: (" + m.group(1) + ", " + m.group(2) + ")");
    map.put(m.group(1), m.group(2));
}