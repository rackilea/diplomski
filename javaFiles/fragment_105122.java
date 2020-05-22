public void log(Level level, String message) {
    LocationInfo locationInfo = new LocationInfo(new Throwable(),
            loggerName);

    MDC.put(LINE_NUMBER, locationInfo.getLineNumber());
    MDC.put(FILE_NAME, locationInfo.getFileName());
    MDC.put(CLASS_NAME, locationInfo.getClassName());
    MDC.put(METHOD_NAME, locationInfo.getMethodName());
    MDC.put(FQMETHOD_NAME, locationInfo.getClassName() + "."
            + locationInfo.getMethodName());

    logger.log(level, message);

    MDC.remove(LINE_NUMBER);
    MDC.remove(FILE_NAME);
    MDC.remove(CLASS_NAME);
    MDC.remove(METHOD_NAME);
    MDC.remove(FQMETHOD_NAME);
}