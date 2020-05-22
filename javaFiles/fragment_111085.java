@Before
    public void setUp() {
        org.apache.logging.log4j.core.Logger logger = (org.apache.logging.log4j.core.Logger) LogManager.getRootLogger();
        PatternLayout layout = PatternLayout.createLayout("%d{HH:mm:ss.SSS} [%t] %-5level %logger{1} - %msg%n%ex",
                null, null, null, Charset.forName("GBK"), false, true, null, null);
        testAppender = TestAppender.createAppender("TestAppender", layout, null, "true");
        testAppender.start();
        logger.getContext().getConfiguration().addLoggerAppender(logger, testAppender);
    }