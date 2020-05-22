@WebListener
public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(final ServletContextEvent sce) {
        final java.util.Timer timer = new Timer();
        // Executes repeatedly (delay = 4000, period = 5000)
        timer.schedule(new ReplyTask(), 4000, 5000);
        sce.getServletContext().setAttribute("replyTaskTimer", timer);
    }

    public void contextDestroyed(final ServletContextEvent sce) {
        final java.util.Timer timer =
          (Timer) sce.getServletContext().getAttribute("replyTaskTimer");
        timer.cancel();
    }
}