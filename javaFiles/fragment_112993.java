public static Map<String, List<Double>> readFile(String path) throws IOException {
    try (Stream<String> stream = Files.lines(Paths.get(path))) {
        return stream.skip(1)
                  .map(l -> l.split(","))
                  .collect(Collectors.groupingBy(
                    keys -> keys[1].replace("\"", ""),
                    Collectors.mapping(keys -> Double.valueOf(keys[2]), Collectors.toList())
                  ));
    }
}