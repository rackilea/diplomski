@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent e)
    {
        CalculationThreadPool.getInstance().getThreadPool().shutdownNow();
    }
}