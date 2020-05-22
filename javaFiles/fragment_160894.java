// Java 9+
String s = "This is a test\nAnd this is also a test\nAnd these are also tests\ntest\nЭто тест\nЭто также тест\nИ это также тесты";
String rx = "(?sU)\\b(\\w+)\\b(?=.*\\b\\1\\b)";
String[] results = Pattern.compile(rx).matcher(s).results().map(MatchResult::group).toArray(String[]::new);
System.out.println(s.replaceAll("(?U)\\b(?:" + String.join("|", results) + ")\\b", "_$0"));

// Java 8
String s = "This is a test\nAnd this is also a test\nAnd these are also tests\ntest\nЭто тест\nЭто также тест\nИ это также тесты";
String rx = "(?sU)\\b(\\w+)\\b(?=.*\\b\\1\\b)";
List<String> matches = new ArrayList<>();
Matcher m = Pattern.compile(rx).matcher(s);
while (m.find()) {
    matches.add(m.group());
}
System.out.println(s.replaceAll("(?U)\\b(?:" + String.join("|", matches) + ")\\b", "_$0"));