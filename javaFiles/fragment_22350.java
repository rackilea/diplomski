public class ParseTask extends Task<Void> {

    private final Path file ;
    private long totalLines ;

    public ParseTask(...) {
        file = ... ;
        totalLines = ... ;
    }

    public Void call() throws IOException {

        // better to use AtomicLong here in case you parallelize the parsing 
        // at any point...
        AtomicLong linesRead = new AtomicLong() ;

        try (Stream<String> stream = Files.lines(file)) {
            stream.forEach(line -> {
                updateProgress(linesRead.incrementAndGet(), totalLines);
                // do stuff with line...
            });
        }

        return null ;
    }

    public long getTotalLines() {
        return totalLines ;
    }
}