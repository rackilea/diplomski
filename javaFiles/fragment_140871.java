ClassPathResource context = new ClassPathResource("applicationContext.xml");
XmlBeanFactory factory = new XmlBeanFactory(context);
String[] beans = factory.getBeanDefinitionNames();
//loop through beans array to get bean names
for (int i=0; i<beans.length; i++) { 
   //do your stuff
}