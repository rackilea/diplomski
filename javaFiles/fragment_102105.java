public class JsonInnerLogsAppender extends AppenderBase<ILoggingEvent> {
    public JsonInnerLogsAppender () {
        this.setName("JSON_LOGGING_INTERNAL");
    }
    @Override
    protected void append(ILoggingEvent eventObject) {
        JsonLogger.putLogInfo(eventObject.getFormattedMessage());
    }
}