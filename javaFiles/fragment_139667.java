Pattern withCE = Pattern.compile("^a\u030A$",Pattern.CANON_EQ);
Pattern withoutCE = Pattern.compile("^a\u030A$");
String input = "\u00E5";

System.out.println("Matches with canon eq: "
    + withCE.matcher(input).matches()); // true
System.out.println("Matches without canon eq: "
    + withoutCE.matcher(input).matches()); // false