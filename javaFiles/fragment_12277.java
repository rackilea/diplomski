private double[][] loadFromFile(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                .map(line -> line.trim().split("\\s+"))
                .map(line -> new double[] {
                    Double.parseDouble(line[1]),
                    Double.parseDouble(line[2])
                })
                .toArray(double[][]::new);
        }
    }