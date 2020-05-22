String pattern = "([^-]*)-([\\D]*)([\\d]*)"; 
String value = "SSS-BB0000";
Matcher matcher = Pattern.compile(pattern).matcher(value); 
if (matcher.find()) {
  System.out.println(matcher.group()); // SSS-BB0000
  System.out.println(matcher.group(0)); // SSS-BB0000
  System.out.println(matcher.group(1)); // SSS
  System.out.println(matcher.group(2)); // BB
  System.out.println(matcher.group(3)); // 0000
}