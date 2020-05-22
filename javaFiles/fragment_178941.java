final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
final Configuration config = ctx.getConfiguration();
String fileName = config.
              getStrSubstitutor().replace("file-with-date-${date:yyyy-MM-dd}.log");

FileAppender fileAppender = FileAppender.newBuilder()
        .withLayout(layout)
        .withFileName(filename)
        .withName("pattern")
        .build();