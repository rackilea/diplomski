class FileToInputStreamTransformer extends AbstractFilePayloadTransformer<InputStream> {

private static final int BUFFER_SIZE = 64 * 1024; // 64 kB

@Override
// @see http://java-performance.info/java-io-bufferedinputstream-and-java-util-zip-gzipinputstream/
protected InputStream transformFile(File payload) throws Exception {
    return new GZIPInputStream(new FileInputStream(payload), BUFFER_SIZE);
}
}

public class RunStatsHandler extends AbstractMessageHandler {

private final SplunkSlf4jLogger log = new SplunkSlf4jLogger(LoggerFactory.getLogger(getClass()));
private static final int BUFFER_SIZE = 64 * 1024; // 64 kB

private final RunStatsRepository runStatsRepository;

public RunStatsHandler(RunStatsRepository runStatsRepository) {
    this.runStatsRepository = runStatsRepository;
}

// Memory efficient routine, @see http://www.baeldung.com/java-read-lines-large-file
@Override
protected void handleMessageInternal(Message<?> message) throws Exception {
    RunStats runStats = message.getHeaders().get(RunStats.RUN, RunStats.class);
    String token = message.getHeaders().get(RunStats.FILE_TOKEN, String.class);
    if (runStats != null) {
        File compressedFile = (File) message.getPayload();
        String compressedFileName = compressedFile.getCanonicalPath();
        LongAdder lineCount = new LongAdder();
        // Streams and Scanner implement java.lang.AutoCloseable
        InputStream fs = new FileInputStream(compressedFile);
        InputStream gzfs = new GZIPInputStream(fs, BUFFER_SIZE);
        try (Scanner sc = new Scanner(gzfs, "UTF-8")) {
            while (sc.hasNextLine()) {
                sc.nextLine();
                lineCount.increment();
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                log.warn("file.lineCount", ImmutableMap.of("run", runStats.getRun(), "file", compressedFileName, 
                        "exception", sc.ioException().getMessage()));
                throw sc.ioException();
            }
            runStats.addFile(compressedFileName, token, lineCount.longValue());
            runStatsRepository.updateRunStats(runStats);
            log.info("file.lineCount",
                    ImmutableMap.of("run", runStats.getRun(), "file", compressedFileName, "lineCount", lineCount.intValue()));
        }
    }
}

}