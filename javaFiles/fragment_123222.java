Map<Integer, Double> map = new HashMap<>();
map.put(260, 223.118);
map.put(261, 1889.00);
map.put(262, 305.70);
map.put(270, 308.00);

String input = "(260+261)-(262+270)";
String result = input;
String pattern = "(\\d+)";

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(input);
StringBuffer sb = new StringBuffer();

while (m.find()) {
    m.appendReplacement(sb, String.valueOf(map.get(Integer.parseInt(m.group(1)))));
}
m.appendTail(sb);
System.out.println(sb.toString());