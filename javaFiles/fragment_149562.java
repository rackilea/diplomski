Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
logger.setLevel(Level.DEBUG);

DriverManagerConnectionSource connSource = new DriverManagerConnectionSource();
connSource.setDataSource(ds);
connSource.setContext(logger.getLoggerContext());
connSource.start();

DBAppender dbAppender = new DBAppender();
dbAppender.setConnectionSource(connSource);
dbAppender.setContext(logger.getLoggerContext());
dbAppender.start();

logger.addAppender(dbAppender);