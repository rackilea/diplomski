// String to be scanned to find the pattern.
String line = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890 234567890";
String pattern = "(.{144}[^ ]*).*";

// Create a Pattern object
Pattern r = Pattern.compile(pattern);

// Now create matcher object.
Matcher m = r.matcher(line);
if (m.find( )) {
 System.out.println(m.replaceAll("$1..."));
} else {
 System.out.println(line);
}