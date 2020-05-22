String input = "Rahul Chowdhury Sunday, January 15, 2012 at 7:37pm EST";
String regex = "(\\w+,\\s+\\w+\\s+\\d+\\,\\s+\\d+\\s+at\\s+\\d+:\\d+(pm|am)\\s+\\w{3,4})";
Matcher matcher = Pattern.compile(regex).matcher(input);
if (matcher.find()) {
  System.out.println(matcher.group(1));
}