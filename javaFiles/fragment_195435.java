private static final PatternStreamer quoteRegex = new PatternStreamer("\"([^\"]*)\"");
public static void main(String[] args) throws Exception {
    String inFileName = "c:\\exec.log";
    String outFileName = "c:\\exec_quoted.txt";
    try (Stream<String> stream = Files.lines(Paths.get(inFileName))) {
        Set<String> dataSet = stream.flatMap(quoteRegex::results)
                                    .map(r -> r.group(1))
                                    .collect(Collectors.toSet());
        Files.write(Paths.get(outFileName), dataSet);
    }
}