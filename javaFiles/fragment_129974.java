CharSequence inputStr = "2 1,3 4,2 6,13";    
String patternStr = "(\\d)\\s+(\\d),";    
// Compile and use regular expression
Pattern pattern = Pattern.compile(patternStr);
Matcher matcher = pattern.matcher(inputStr);

while (matcher.find()) {
    // Get all groups for this match
    for (int i=0; i<=matcher.groupCount(); i++) {
        String groupStr = matcher.group(i);
    }
}