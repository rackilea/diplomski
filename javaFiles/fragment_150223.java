LoggingErrorHandler errorHandler = new LoggingErrorHandler();
validator.setErrorHandler(errorHandler);
validator.validate(invalidXmlSource);
if (!errorHandler.isValid()) {
    //...
}