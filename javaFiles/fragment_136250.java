public static String replaceKeywords(
        final String template, 
        final Map<String, String> map
) {
    return map.keySet().stream().reduce(template, 
            (acc, key) -> acc.replaceAll("\\$\\(" + key + "\\)", map.get(key)));
}