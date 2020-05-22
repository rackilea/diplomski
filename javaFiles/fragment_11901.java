public class LoggerFactory implements Factory<ILogger> {

    // inject stuff here if you need (just an useless example)
    @Inject
    public LoggerFactory(final UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    @Override
    public ILogger provide() {
        // here you resolve you ilogger
        return MyLocator.resolve(ILogger.class);
    }

    @Override
    public void dispose(ILogger instance) {
        // ignore
    }

}