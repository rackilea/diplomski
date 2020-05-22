Pattern p = Pattern.compile("(\\d)(.*)(\\d)");
String input = "6 example input 4";
Matcher m = p.matcher(input);
if (m.find()) {
    // replace first number with "number" and second number with the first
    String output = m.replaceFirst("number $3$1");  // number 46
}