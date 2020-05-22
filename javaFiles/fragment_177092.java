String test = "My/word example/word";
Pattern pattern = Pattern.compile("(\\w+)/word");
Matcher match = pattern.matcher(test);
while (match.find()) {
    System.out.println(match.group(1));
}