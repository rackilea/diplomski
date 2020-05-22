public class Main {
    public static void main( String[] args ) throws IOException, InterruptedException {     
        //TODO load proper configs depending on args 
        //TODO initiate dataSource bean with UN and PS in args
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-common.xml") {
          protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
           super.prepareBeanFactory(beanFactory);
           beanFactory.registerSingleton("dataSource", dataSource);
          }
        };
   }
}