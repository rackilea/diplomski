String theNumbers = null;
Pattern regex = Pattern.compile("\\d+");
Matcher regexMatcher = regex.matcher(subjectString);
if (regexMatcher.find()) {
    theNumbers = regexMatcher.group();
} 
else subjectString = "0";