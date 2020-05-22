// your format
DecimalFormat formatter = new DecimalFormat("#,###.##");
// your input
String input = "9000 + 1000 x 2";
// StringBuffer holding the replaced String
StringBuffer result = new StringBuffer(input.length());
// pattern for 1+ consecutive digits
Pattern pattern = Pattern.compile("\\d+");
// matcher for your input
Matcher matcher = pattern.matcher(input);
// iterating over matches
while (matcher.find()) {
    // replacing matches
    matcher.appendReplacement(
        result, 
        formatter.format(Integer.valueOf(matcher.group()))
    );
}
// appending tail (not applicable in this example, but need to have)
matcher.appendTail(result);
// printing result
System.out.println(result);