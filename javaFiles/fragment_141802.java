// your inputs for the sake of a working example snippet
String text = "K1234 T1234567";
String query = "([A-Z]{1}[0-9]{4})((\\ ){1})([A-Z]{1}[0-9]{7})";
String format = "\\4, \\1";

// usual regex pattern matching
Pattern pattern = Pattern.compile(query);
Matcher matcher = pattern.matcher(text);
matcher.find();

// you need to tweak the format to use $ instead of \ for replacement
String replacement = format.replaceAll("\\\\", "\\$");
String result = matcher.replaceAll(replacement);

// this outputs "T1234567, K1234"
System.out.println(result);