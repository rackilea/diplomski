final String fileName = "someFileName";
double[][] data;
try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
      data = stream.map(line -> line.split("\\s+"))
                   .map(a -> Arrays.stream(a).mapToDouble(Double::parseDouble).toArray()) 
                   .toArray(double[][]::new);  
} catch (IOException e) { e.printStackTrace(); }