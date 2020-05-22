public static List<Edge> readEdges(String filename) throws IOException {
        try (Stream<String> linesStream = Files.lines(Paths.get(filename))) {
            return linesStream
                    .map(line -> new Edge(new Scanner(line)))
                    .collect(Collectors.toList());
        }
    }