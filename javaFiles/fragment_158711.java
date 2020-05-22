public Map<String, List<String>> splitQuery(URL url) {
    if (Strings.isNullOrEmpty(url.getQuery())) {
        return Collections.emptyMap();
    }
    return Arrays.stream(url.getQuery().split("&"))
            .map(this::splitQueryParameter)
            .collect(Collectors.groupingBy(SimpleImmutableEntry::getKey, LinkedHashMap::new, mapping(Map.Entry::getValue, toList())));
}

public SimpleImmutableEntry<String, String> splitQueryParameter(String it) {
    final int idx = it.indexOf("=");
    final String key = idx > 0 ? it.substring(0, idx) : it;
    final String value = idx > 0 && it.length() > idx + 1 ? it.substring(idx + 1) : null;
    return new SimpleImmutableEntry<>(key, value);
}