Pattern regex = Pattern.compile("^Did (.+)\s+(\w+)\s+or\s+(\w+)$", 
                                  Pattern.CASE_INSENSITIVE | 
                                  Pattern.UNICODE_CASE);
Matcher regexMatcher = regex.matcher(subjectString);
if (regexMatcher.find()) 
{
  String []person = regexMatcher.group(0).split(" ");
  String action1 = regexMatcher.group(1);
  String action2 = regexMatcher.group(2);
}