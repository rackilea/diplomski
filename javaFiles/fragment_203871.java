// Suppose this returned the matched string
Matcher matcher = pattern.matcher(s);  

// Need to check whether there was actually a match
if (matcher != null) {  // Prints only the first match

    System.out.println(matcher.group());
}