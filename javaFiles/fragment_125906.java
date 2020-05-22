try (BufferedReader reader = Files.newBufferedReader(f.toPath(), 
                                  StandardCharsets.UTF_8)) {

    Stream<String> firstLine = Stream.of(reader.readLine());
    Stream<String> linesFiltered = reader.lines()
            .filter(e -> e.contains(sdfFileContent.format(fileDate)));
    Stream<String> result = Stream.concat(firstLine, linesFiltered);

    ...