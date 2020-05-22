Pattern regex = Pattern.compile("^X[LC]");
Matcher regexMatcher = regex.matcher(subjectString);
if(regexMatcher.find() )  { // it matched!
}
else { // nasty message
     }