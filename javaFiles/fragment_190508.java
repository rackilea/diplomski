String p = "From:.+\r?\nSent:.+\r?\nTo:.+\r?\nSubject:.+"; 
// String p = "From:.+\\RSent:.+\\RTo:.+\\RSubject:.+";  // Java 8+ compliant
String s = "Some text before.....\r\nFrom: ***********************\r\nSent: ***********************\r\nTo: ***********************\r\nSubject: *******************"; 
Pattern pattern = Pattern.compile(p);
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(0)); 
}