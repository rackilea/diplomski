public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = 
          new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean mybean = context.getBean(MyBean.class);
        mybean.save();
    }

}