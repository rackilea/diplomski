String pattern = "(?<Words>[^ ,.][^,.]*(?=(,|\\.)))";
String text = "Part one, part two. Part three";
Matcher m = Pattern.compile(pattern).matcher(text);
while (m.find()) {
    System.out.println(m.group("Words"));
}