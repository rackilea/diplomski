public class TouchPointsSpringContext
{
  private static final Log g_log = LogFactory.getLog(TouchPointsSpringContext.class);
  private static volatile ApplicationContext CONTEXT;
  private static final Object lock = new Object();

  private static ApplicationContext initializeTouchPointService()
  {
    g_log.info("getting touchpoints service application context");
    String[] locations =
        { "appContext-main.xml", "appContext-hibernate.xml" };
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(locations);
    g_log.info("setting touchpoints service application context");
    return applicationContext;
  }

  public static Object getBean(String beanName)
  {
    if (CONTEXT == null)
    {
        synchronized (lock)
        {
           if (CONTEXT == null)
           {
              CONTEXT = initializeTouchPointService();
           }
        }
    }
    return CONTEXT.getBean(beanName);
   }

   public static void main(String[] args)
   {
       TouchPointsSpringContext.getBean("lookupService");
   }
}