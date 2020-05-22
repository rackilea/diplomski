private static Map<String, String> REPLACEMENTS = new HashMap<>();
static {
    REPLACEMENTS.put("aa","AA");
    REPLACEMENTS.put("bb","BB");
}
    public static String replace(String input) {
    StringBuilder sb = new StringBuilder(input.length());
    for (int i = 0; i < input.length(); ++i) {
        i += replaceFrom(input, i, sb);
    }
    return sb.toString();
}

private static int replaceFrom(String input, int startIndex, StringBuilder sb) {
    for (Map.Entry<String, String> replacement : REPLACEMENTS.entrySet()) {
        String toMatch = replacement.getKey();
        if (input.startsWith(toMatch, startIndex)) {
            sb.append(replacement.getValue());
            //we matched the whole word skip all matched characters
            //not just the first
            return toMatch.length() - 1;
        }
    }
    sb.append(input.charAt(startIndex));
    return 0;
}