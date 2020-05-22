public class StackPrintingFileAppender extends FileAppender {
    protected void subAppend(LoggingEvent event) {
        new Exception().printStackTrace(new PrintWriter(qw));
        super.subAppend();
    }
}