StringBuffer resultString = new StringBuffer();
String subjectString = new String("qqqq");
Pattern regex = Pattern.compile("q");
Matcher regexMatcher = regex.matcher(subjectString);
int i = 1;
while (regexMatcher.find()) {
   regexMatcher.appendReplacement(resultString, i+":"+regexMatcher.group(1)+" ");
   i++;
}
regexMatcher.appendTail(resultString);
System.out.println(resultString);