public class NotifyingContextLoaderListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            super.contextInitialized(event);
            //generate success event
        }
        catch (RuntimeException e) {
            //generate failure event
            throw e;
        }
    }
}