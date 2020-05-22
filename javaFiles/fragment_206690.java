// your special characters
String regex = "+ – && || ! ( ) { } [ ] ^ ” ~ * ? : \\";
// building a valid regex out of above
regex = '(' + regex.replaceAll("([^\\s]{1,2})(?=(?:\\s+|$))",
                               "\\\\Q$1\\\\E").replace(' ', '|') + ')';

// your string to be replaced
String str = "content:you&&me";
// actual replacement
str = str.replaceAll(regex, "\\\\$1");

// printing the result
System.out.printf("********* replaced: [%s]%n", str);