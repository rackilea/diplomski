@Configuration
public class JdbcAppenderConfiguration {
    @Autowired
    private DataSource dataSource;

    //Or @PostConstruct
    @EventListener
    public void handleContextStart(ContextStartedEvent cse) {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        final Configuration config = ctx.getConfiguration();
        ColumnConfig[] cc = {
            ColumnConfig.createColumnConfig(config, "date", null, null, "true", null, null),
            ColumnConfig.createColumnConfig(config, "level", "%level", null, null, null, null),
            ColumnConfig.createColumnConfig(config, "logger", "%logger", null, null, null, null),
            ColumnConfig.createColumnConfig(config, "message", "%message", null, null, null, null),
            ColumnConfig.createColumnConfig(config, "throwable", "%ex{short}", null, null, null, null),
            ColumnConfig.createColumnConfig(config, "salarie_id", "%X{SALARIE_ID}", null, null, null, null)
        } ;     
        Appender appender = JdbcAppender.createAppender("databaseAppender", "true", null, new Connect(dataSource), "0", "sicdb.bo_log", cc);
        appender.start();
        config.addAppender(appender);
        LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
        loggerConfig.addAppender(appender, null, null);
        ctx.updateLoggers();
    }
}