public class TestAppender extends AppenderSkeleton {
    public List<String> messages = new ArrayList<String>();

    public void doAppend(LoggingEvent event) {
        messages.add( event.getMessage().toString() );
    }
}