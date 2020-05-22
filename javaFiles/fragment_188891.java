String input = "(123-456)-12-1";
Pattern pattern = Pattern.compile("([()-]|\\d+)");
Matcher matcher = pattern.matcher(input);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}