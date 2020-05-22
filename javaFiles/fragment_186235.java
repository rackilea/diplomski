public static void main(String... ignored) {
    for (String test : "aabaa,wwwaabcdddd,abcddtxyz".split(",")) {
        System.out.println(test + " matches " + longestMatch(test, "aab*", "aabc*", "aabcdd*", "dtctddds*", "ddt"));
    }
}

public static String longestMatch(String text, String... regex) {
    String[] sortedRegex = regex.clone();
    Arrays.sort(sortedRegex, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o2.length() - o1.length();
        }
    });
    StringBuilder sb = new StringBuilder();
    String sep = "(";
    for (String s : sortedRegex) {
        sb.append(sep).append('(').append(s).append(')');
        sep = "|";
    }
    sb.append(")");
    Matcher matcher = Pattern.compile(sb.toString()).matcher(text);
    if (matcher.find()) {
        for (int i = 2; i <= matcher.groupCount(); i++) {
            String group = matcher.group(i);
            if (group != null)
                return sortedRegex[i - 2];
        }
    }
    return "";
}