public static String stripComments(String text, String[] commentSymbols) {
    String[] lines = text.split("\n");
    // escape the comment symbols so that they can be used as regex
    List<String> escapedCommentSymbols = Arrays.stream(commentSymbols).map(Pattern::quote).collect(Collectors.toList());
    for(int i = 0 ; i < lines.length ; i++) {
        // create a regex that matches the comment portion of a line
        String regex = "(" + String.join("|", escapedCommentSymbols) + ").+$";
        lines[i] = lines[i].replaceAll(regex, "");
        // replace trailing whitespace even if it is not a comment.
        lines[i] = lines[i].replaceAll("\\s+$", "");
    }
    return String.join("\n", (CharSequence[]) lines);
}