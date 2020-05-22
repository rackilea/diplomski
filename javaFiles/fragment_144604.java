static class Log extends AbstractMarshallable {
    String mkey;
    LocalDateTime timestamp;
    String msg;
}

int count;

public void myMethod() {
    Log log = new Log();
    final SingleChronicleQueue q = SingleChronicleQueueBuilder.binary(new File("q4")).build();
    final ExcerptAppender appender = q.acquireAppender();
    final ExcerptTailer tailer = q.createTailer();

    try (final DocumentContext dc = appender.writingDocument()) {
        // this will store the contents of log to the queue
        dc.wire().write("log").marshallable(log);
    }

    try (final DocumentContext dc = tailer.readingDocument()) {
        if (!dc.isData())
             return;
        // this will replace the contents of log
        dc.wire().read("log").marshallable(log);
        //... do more stuff, like updating counters
        count++;
    }
}