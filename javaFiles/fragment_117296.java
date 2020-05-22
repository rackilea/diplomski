@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // Do here the job.
    }

    // ...
}