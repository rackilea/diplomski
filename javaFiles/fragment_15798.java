String input = "(A + B / C)+(A / B)";

//capture a group for each expression contained by parentheses
Pattern pattern = Pattern.compile("(\\(.*?\\))");

//create a matcher to apply the pattern to your input
Matcher matcher = pattern.matcher(input);

//find every match and add them to a list
List<String> expressions = new ArrayList<>();
while(matcher.find()) {
    expressions.add(matcher.group());
}

System.out.println(expressions);