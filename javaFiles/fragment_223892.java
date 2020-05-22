Path inputFile = Paths.get("C:\\Users\\Desktop\\sample.txt");
Path outputFile = inputFile.resolveSibling("new-sample.txt");

String separator = " ", newLine = System.getProperty("line.separator");
Pattern p = Pattern.compile(separator);
try(BufferedReader br = Files.newBufferedReader(inputFile);
    BufferedWriter bw = Files.newBufferedWriter(outputFile, StandardOpenOption.CREATE)) {

    bw.append(br.readLine()).append(newLine); // header
    br.lines()
      .sorted(Comparator.comparingDouble(line ->
          -p.splitAsStream(line).skip(1).mapToInt(Integer::parseInt).average().orElse(-1)))
      .forEachOrdered(s -> {
        try { bw.append(s).append(newLine); }
        catch(IOException ex) { throw new UncheckedIOException(ex); }
    });
}