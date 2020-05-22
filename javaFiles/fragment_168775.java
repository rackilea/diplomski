Pattern pattern = Pattern.compile("\\d*(\\$|£)");

String input = "1£23$456$£$";
Matcher matcher = pattern.matcher(input);
List<String> output = new ArrayList<>();
while (matcher.find()) {
    output.add(matcher.group());
}