@Component
public class MyEventAnnotationBeanPostProcessor implements BeanPostProcessor
{
   private static Logger logger = LoggerFactory.getLogger(MyEventAnnotationBeanPostProcessor.class);

   @Autowired
   AbstractApplicationContext ctx;

   @Override
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
   {
      for (Method method: bean.getClass().getMethods()) {
         if (method.isAnnotationPresent(MyEventAnnotation.class)) {
            MyEventAnnotation annotation = method.getAnnotation(MyEventAnnotation.class);
            ctx.addApplicationListener(createApplicationListener(method, bean, annotation.topic()));
         }
      }
      return bean;
   }

   private ApplicationListener<MyEvent> createApplicationListener(Method m, Object bean, String topic) {
      return (MyEvent e) -> {
         if (topic.equals("") || e.getTopic().equals(topic)) { // Filter here!
            try {
               m.invoke(bean, e);
            } catch (IllegalAccessException e1) {
               e1.printStackTrace();
            } catch (InvocationTargetException e1) {
               e1.printStackTrace();
            }
         }
      };
   }
}