// Compile and use regular expression
RegExp regExp = RegExp.compile(patternStr);
MatchResult matcher = regExp.exec(inputStr);
boolean matchFound = matcher != null; // equivalent to regExp.test(inputStr); 

if (matchFound) {
    // Get all groups for this match
    for (int i = 0; i < matcher.getGroupCount(); i++) {
        String groupStr = matcher.getGroup(i);
        System.out.println(groupStr);
    }
}