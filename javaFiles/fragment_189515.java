private static final Pattern DELIMITER = Pattern.compile(":");

Map<String, List<String>> locationMap = locations.stream()
    .map(s -> DELIMITER.splitAsStream(s).toArray(String[]::new))
        .collect(Collectors.groupingBy(a -> a[0], 
            Collectors.mapping(a -> a[1], Collectors.toList())));