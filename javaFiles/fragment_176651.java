String phraseToReplace = "1-800 flowers.com, CO.";

String sentence = "blablabla " + phraseToReplace + " waddawaddawadda";
Pattern pattern = Pattern.compile("(\\s|^)((?i)" + Pattern.quote(phraseToReplace)
            + ")(\\s|$)", Pattern.MULTILINE);
Matcher m = pattern.matcher("1-800 flowers.COM, CO.");
String match = null;
if (m.matches()) {
    match = m.group(2);
}
if (match != null) {
    System.out.printf("Matched: \"%s\"%n", match);
    System.out.printf("Equals to \"phraseToReplace\"? %b%n", match.equals(phraseToReplace));
    System.out.printf("Equals to \"phraseToReplace\" ignoring case? %b%n",
            match.equalsIgnoreCase(phraseToReplace));
    System.out.printf("Contained in \"sentence\"? %b%n", sentence.contains(match));
    System.out.printf("Contained in \"sentence\" ignoring case? %b%n", sentence.toLowerCase().contains(match.toLowerCase()));
}