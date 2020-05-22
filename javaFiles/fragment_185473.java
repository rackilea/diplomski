private static final Pattern numberPattern = Pattern.compile("(\\d+)");

public static List<Integer> list(String pseudoJson) {
    Matcher matcher = numberPattern.matcher(pseudoJson);
    List<Integer> list = new ArrayList<>();
    while(matcher.find()) {
        list.add(Integer.valueOf(matcher.group(1)));
    }
    return list;
}