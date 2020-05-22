String input = "sometext {10} some text {25} sometext";
Pattern p = Pattern.compile("\\{\\d+\\}");
Matcher m = p.matcher(input);
while (m.find()) {
    System.out.println(m.group());
}