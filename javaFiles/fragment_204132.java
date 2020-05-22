String valid = "abc";
String invalid = "abc3";
Pattern pattern = Pattern.compile("^\\p{Alpha}+$"); // use \\p{L} for Unicode support
Matcher matcher = pattern.matcher(valid);
System.out.println(matcher.matches());
matcher = pattern.matcher(invalid);
System.out.println(matcher.matches());