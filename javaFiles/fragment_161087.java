String value = "RRRRBBBRRBBBRBBBRRR";
Pattern pattern = Pattern.compile("B+|R+");
Matcher matcher = pattern.matcher(value);
while (matcher.find()) {
    System.out.println(matcher.group());
}