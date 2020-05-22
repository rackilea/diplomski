String s = "hey,my,name,\"john,boy\",age,male";
Pattern p = Pattern.compile("\"([^\"]+)\"|[^,]+");
Matcher m = p.matcher(s);
List<String> words = new ArrayList<>();

while (m.find()) {
    words.add(m.group(1) == null ? m.group() : m.group(1)); // store all the found words in this ArrayList
}

String[] line1 = words.toArray(new String[words.size()]);
String slNo = line1[0];
String customerId = line1[1];
String customerCategory = line1[2];

words.forEach(System.out::println);