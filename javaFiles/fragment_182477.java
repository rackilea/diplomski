Pattern pattern = Pattern.compile("[-]?[0-9]*[.][0-9]+");
String text = "|AAA--A A05_#A| |-999.999| |-55.7|";
Matcher matcher = pattern.matcher(text);
while (matcher.find()) {
    System.out.println(matcher.group());
}