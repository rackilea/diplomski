private @Autowired ListableBeanFactory beanFactory;

public void doStuff() {
   for (String beanName : beanFactory.getBeanDefinitionNames()) {
      if (beanName.startsWith("env")) { // or whatever check you want to do
         Object bean = beanFactory.getBean(beanName)
         // .. do something with it
      }
   }
}