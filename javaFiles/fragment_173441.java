public class MainApp {
   public static void main(String[] args) {

      ApplicationContext context = 
                          new ClassPathXmlApplicationContext("Beans.xml");//error here

      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();
      context.registerShutdownHook();
   }
}