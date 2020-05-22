Pattern pattern = Pattern.compile("(?:\\b)(\\w+?)=(\\w+?)(?:\\b)");
Matcher matcher = pattern.matcher(str);

while (matcher.find()) {
    System.out.println(matcher.group(1) + " : " + matcher.group(2));
}