Path inputFile = Paths.get("C:\\Users\\Desktop\\sample.txt");
Path outputFile = inputFile.resolveSibling("new-sample.txt");

String separator = " ";
Pattern p = Pattern.compile(separator);

List<String> lines = Files.readAllLines(inputFile);
lines.subList(1, lines.size())
     .sort(Comparator.comparingDouble(line ->
         -p.splitAsStream(line).skip(1).mapToInt(Integer::parseInt).average().orElse(-1)));
Files.write(outputFile, lines, StandardOpenOption.CREATE);