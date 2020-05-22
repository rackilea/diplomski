import mypackage.PayloadLogAppender;

// in the method that gets triggered at the end.
this.LOGGER = Logger.getRootLogger();
Appender payloadlog = this.LOGGER.getAppender("payloadLog");
System.out.println("My list of logging events" + ((PayloadLogAppender) payloadlog).getAllMessage());