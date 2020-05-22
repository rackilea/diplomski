// Create the Regex pattern
Pattern p = Pattern.compile("(StreamTitle=')(.*)(';StreamUrl)");
// Create a matcher that matches the pattern against your input
Matcher m = p.matcher(metadataHeader);
// if we found a match
if (m.find()) {
    // the filename is the second group. (The `(.*)` part)
    filename = m.group(2);
}