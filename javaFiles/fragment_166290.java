private static List<String> findRexExpList(String text, String regExp) {
    List<String> result = new ArrayList<>();
    Pattern pattern = Pattern.compile(regExp);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
        String group = matcher.group();
        result.add(group);
    }
    return result;
}