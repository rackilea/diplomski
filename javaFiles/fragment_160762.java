Logger rootLogger = LogManager.getLogManager().getLogger("");
rootLogger.setFilter(new Filter() {
    @Override
    public boolean isLoggable(LogRecord record) {
            return "something".equals(record.getLoggerName());
    }
});