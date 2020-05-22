private static final Pattern pattern = Pattern.compile("[ACGT]\\.\\{\\d+\\}");

public static List<String> extract(String input) {
    Matcher matcher = pattern.matcher(input);
    List<String> result = new ArrayList<String>();

    while (matcher.find()) {
        result.add(matcher.group(0));
    }

    return result;
}

public static Set<String> compose(List<String> elements, int window) {
    Set<String> result = new HashSet<String>();

    for (int i = 0; i <= elements.size() - window; i++) {
        StringBuilder builder = new StringBuilder(".*");
        for (int j = i; j < i + window; j++) {
            builder.append(elements.get(j));
        }
        // This strips the final quantifier turning:
        // .*C.{0}A.{2}T.{0}T.{0}
        // into
        // .*C.{0}A.{2}T.{0}T
        builder.delete(builder.lastIndexOf("."), builder.length());

        builder.append(".*");
        result.add(builder.toString());
    }

    return result;
}