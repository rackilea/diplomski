public static String classify(String str) {
    return urlPattern.matcher(str).matches() ? "url" : 
        emailPattern.matcher(str).matches() ? "email" : null;
}

Map<String, Set<String>> map = Files.lines(filePath)
        .map(str -> new AbstractMap.SimpleEntry<>(classify(str), str))
        .filter(e -> e.getKey() != null)
        .collect(Collectors.groupingBy(e -> e.getKey(),
            Collectors.mapping(e -> e.getValue(), Collectors.toSet())));