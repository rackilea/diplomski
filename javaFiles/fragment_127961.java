void apply(Project project) {
    OutputEventListenerBackedLoggerContext context = (OutputEventListenerBackedLoggerContext)  LoggerFactory.getILoggerFactory();

    context.reset()
    context.setOutputEventListener(new StfuLogger())
}


class StfuLogger implements OutputEventListener {
    @Override
    void onOutput(OutputEvent event) {
        LogEvent logEvent = (LogEvent) event
        if(!logEvent.category.contains("com.netflix")) {
            println(logEvent.message)
        }
    }
}