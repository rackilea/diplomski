String MIDDLESIGN = "[(\\/)"+"|"+"(\\*)"+"|"+"(\\++)"+"|"+"(\\-+)]";
String x = "1 +++ 2 * 3 -- 4";
System.out.println("1 +++ 2 * 3 -- 4".matches("(\\d+\\s+" + MIDDLESIGN + "*" + "\\s+\\d*)+")); // true

Pattern pattern = Pattern.compile("(\\d+\\s+" + MIDDLESIGN + "*" + "\\s+\\d*)+");
Matcher matcher = pattern.matcher(x);
System.out.println(matcher.matches()); // true