String input = "abab1ab2ab3bcaab4ab5ab6";
Pattern pattern = Pattern.compile("(?=((?:ab.){2}))");
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {
    System.out.println(matcher.start() + " " + matcher.group(1));
}