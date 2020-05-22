String a = "100.00";
String b = "10.00";
String c =  "5.00";

List<String> strings = Arrays.asList(a, b, c);

int maxLen = -1;
for (String s : strings) maxLen = Math.max(maxLen, s.length());
for (String s : strings) {
    String spaces = "";
    for (int i = 0; i < maxLen - s.length(); ++i) {
        spaces += " ";
    }
    System.out.println(spaces += s);
}