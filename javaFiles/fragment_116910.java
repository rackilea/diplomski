Pattern tokenPattern  = Pattern.compile("\\s+|\\S+");
String text = "\tSome \n\t text \n that needs \t parsing.";
List<String> tokens = new ArrayList<String>();
Scanner scanner = new Scanner(text);
while (true) {
    String token = scanner.findWithinHorizon(tokenPattern, 0);
    if (token == null) break;
    tokens.add(token);
}
System.out.println(tokens);