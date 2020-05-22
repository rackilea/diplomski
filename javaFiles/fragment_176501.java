@WebListener
public class SomeObjectInitializer implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setAttribute("someObject", new SomeObject());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // NOOP.
    }

}