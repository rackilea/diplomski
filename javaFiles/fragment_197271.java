public class MyApp2 {
   public static void main(String[] args) {
     DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // Define a bean and register it
     BeanDefinition beanDefinition = BeanDefinitionBuilder.
       rootBeanDefinition(Arrays.class, "asList")
       .addConstructorArgValue(args).getBeanDefinition();
     beanFactory.registerBeanDefinition("args", beanDefinition);
     GenericApplicationContext cmdArgCxt = new GenericApplicationContext(beanFactory);
     // Must call refresh to initialize context 
     cmdArgCxt.refresh();

     // Create application context, passing command line context as parent
     ApplicationContext mainContext = new ClassPathXmlApplicationContext(CONFIG_LOCATIONS, cmdArgCxt);

     // See if it's in the context
     System.out.println("Args: " + mainContext.getBean("args"));
   }

   private static String[] CONFIG_LOCATIONS = new String[] {
     "applicationContext.xml"
   };

 }