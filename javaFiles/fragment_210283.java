String file = "hello /* line 1 \n line 2 \n line 3 */"
            + "there /* line 4 */ world";

StringBuffer sb = new StringBuffer();
Matcher m = Pattern.compile("(?m)/\\*([^*]|(\\*+[^*/]))*\\*+/").matcher(file);

while (m.find()) {

    // Find a comment
    String toReplace = m.group();

    // Figure out what to replace it with
    String replacement = toReplace.contains("\n") ? "\n" : "";

    // Perform the replacement.
    m.appendReplacement(sb, replacement);
}

m.appendTail(sb);

System.out.println(sb);