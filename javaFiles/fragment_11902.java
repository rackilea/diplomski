public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(LoggerFactory.class).to(ILogger.class).in(PerLookup.class /* or other scopeAnnotation if needed */);

        // what's you Logger.class ? 
        // bind(Logger.class).to(ILogger.class).in(Singleton.class);      
        // bind(MySqlRepository.class).to(IRepository.class).in(Singleton.class);
    }
}