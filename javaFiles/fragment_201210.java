String myString = "deptid = 33 AND location = 'New York'";
List<String> tokens = new LinkedList<>();

Pattern tokenPattern = Pattern.compile("'[^']*'|[^ ]+");
Matcher matcher = tokenPattern.matcher(myString);
while(matcher.find()) {
    tokens.add(matcher.group());
}

System.out.println(tokens);