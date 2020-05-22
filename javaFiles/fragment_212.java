private static String removeMarkupBetweenDollars(String input) {
    if ((input.length() - input.replaceAll("\\$", "").length()) % 2 != 0) {
        throw new RuntimeException("Missing or extra: dollar");
    }

    Pattern pattern = Pattern.compile("\\$(.*?)\\$", Pattern.DOTALL);
    Matcher matcher = pattern.matcher(input);

    StringBuffer sb = new StringBuffer();

    while (matcher.find()) {
        String s = matcher.group().replaceAll("<[^>]+>", "");
        matcher.appendReplacement(sb, Matcher.quoteReplacement(s));
    }
    matcher.appendTail(sb);

    return sb.toString();
}