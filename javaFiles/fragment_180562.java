public class LenartQuartzListener extends QuartzInitializerListener {

    @Override
    public void contextInitialized(ServletContextEvent evt) {
        super.contextInitialized(evt);
        // At this point, the default functionality
        // has been executed hence the scheduler has been created!
        ServletContext ctx = evt.getServletContext();
        StdSchedulerFactory factory = (StdSchedulerFactory)
          ctx.getAttribute("org.quartz.impl.StdSchedulerFactory.KEY");
        try {
            scheduleMainJob(factory.getScheduler("LenartScheduler"));
        } catch (SchedulerException e) {
            // properly handle the exception...
        }
    }
}