public class SpringContext {

   public ClassPathXmlApplicationContext context;

   private static SpringContext _instance = new SpringContext();

   private SpringContext() {
      context = new ClassPathXmlApplicationContext(new String[]{"ThreadPoolConfig.xml"});
   }

   public static SpringContext getInstance() {
      return _instance;
   }


   public Object getBean(String bean) {
      Object beanObj = (context != null) ? context.getBean(bean) : null;
      return beanObj;
   }

}