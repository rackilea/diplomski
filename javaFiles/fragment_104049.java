// before the outer for loop
Pattern regex = Pattern.compile("natives-\\d{14}$");

// later
Matcher regexMatcher = regex.matcher(listOfFiles2[f].getName());
if(regexMatcher.find()) {... success ...}