String input = "I am Duc/N Ta/N Van/N";
String regex = "([^\\s]+)/N";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);
String result = matcher.results().map(s -> s.group(1)).collect(Collectors.joining(" "));

System.out.println("Name: " + result); // Name: Duc Ta Van