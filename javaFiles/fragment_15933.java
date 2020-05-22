public static void main(String[] args) {
    String text = "Magic banana is eating the apple.";
    System.out.println("Old text: " + text);
    System.out.println("New text: " + getEditedText(text));
}

private static String getEditedText(String text) {
    StringBuffer result = new StringBuffer();
    Pattern pattern = Pattern.compile("[A-Za-z][a-z]*");
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
        matcher.appendReplacement(result, getReplacement(matcher));
    }
    matcher.appendTail(result);
    return result.toString();
}

private static String getReplacement(Matcher matcher) {
    String word = matcher.group(0);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        sb.append((char)(c + 1));
    }
    return sb.toString();
}