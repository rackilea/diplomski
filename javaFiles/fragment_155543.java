String text = "Did you eat yet?";
// will match a String containing both words "eat", 
// then "yet" in that order of appearance, case-insensitive
//                           | word boundary
//                           |        | any character, zero or more times 
Pattern p = Pattern.compile("\\beat\\b.*\\byet\\b", Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(text);
System.out.println(m.find());