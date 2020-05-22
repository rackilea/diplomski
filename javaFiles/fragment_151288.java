Pattern intPattern = Pattern.compile("\\d+");
try(Scanner scanner = new Scanner(Paths.get("foo.txt"));
    BufferedWriter writer = Files.newBufferedWriter(Paths.get("bar.txt"), CREATE_NEW)) {

    String firstLine = scanner.findWithinHorizon(intPattern, 0);
    if(firstLine == null) {
        // perform empty action
    } else {
        // perform pre action
        Stream.concat(Stream.of(firstLine),
                      scanner.findAll(intPattern).map(MatchResult::group))
            .forEach(line -> convertCheckedIOException(() ->  {
                    writer.write(line);
                    writer.newLine();
                })
            );
        // perform post action
    }
}