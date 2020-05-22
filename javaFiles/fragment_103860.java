// Apply the Regular Expression to Pattern
Pattern regex = Pattern.compile("\\{(.*?)\\}");
// Run the pattern to see if there are any matches.
Matcher matcher = regex.matcher(inputString);

// Establish a String List Object to hold any matches.
List<String> list = new ArrayList<>();

// Retrieve any matches found and add to List.        
while (matcher.find()) {
    list.add(matcher.group(1));
}