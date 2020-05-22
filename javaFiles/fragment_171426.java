final inputText = ...
final Pattern pattern = Patern.compile("Some regex code");
final Matcher matcher = pattern.matcher(input);
if (matcher.find()) {
    System.out.println(matcher.group(0));
}