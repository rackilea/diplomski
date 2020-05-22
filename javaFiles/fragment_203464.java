Pattern digitPattern = Pattern.compile("(\\d)"); // EDIT: Increment each digit.

Matcher matcher = digitPattern.matcher("test1check2");
StringBuffer result = new StringBuffer();
while (matcher.find())
{
    matcher.appendReplacement(result, String.valueOf(Integer.parseInt(matcher.group(1)) + 1));
}
matcher.appendTail(result);
return result.toString();