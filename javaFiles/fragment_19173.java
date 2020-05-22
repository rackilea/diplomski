HashMap<String, String> map = new HashMap<String, String>(); 
 Pattern regex = Pattern.compile("(\\[\\w+\\])\\s+(\\w+)");
 Matcher regexMatcher = regex.matcher(subjectString);
 while (regexMatcher.find()) {
     // matched text: regexMatcher.group(i)
     // add group 1 to key and group 2 to value of hash
     map.put(regexMatcher.group(1), regexMatcher.group(2));
 }