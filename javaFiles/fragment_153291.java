public class ComponentA implements Component
{
    private Logger logger = LogManager.getLogger();
    public ComponentA(String componentName)
    {
        this.logger = this.createLogger(componentName, "MyOriginalFileAppender", componentName+"Appender", true, Level.DEBUG, this.logger);
    }
}