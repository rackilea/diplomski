try (Stream<Path> stream = Files.list(Paths.get("path/to/your/file"))) {
    Map<String, Long> fileExtCountMap = stream.filter(Files::isRegularFile)
        .map(f -> f.getFileName().toString().toUpperCase())
        .map(n -> n.substring(n.lastIndexOf(".") + 1))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}