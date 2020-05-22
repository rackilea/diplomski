public class Test {
    public static void main(String args[]) throws Exception {
       ApplicationContext ctx = new AnnotationConfigApplicationContext(Factory.class);
       // calls the @Bean factory method for the myBean bean with the argument provided
       ctx.getBean("myBean", "first"); 
       ctx.getBean("myBean", "second");
    }
}

@Configuration
class Factory {
    @Bean()
    @Scope("prototype")
    public MyBean myBean(String arg) {
        return new MyBean(arg);
    }
}

class MyBean {
    public MyBean(String arg) {
        System.out.println(arg);
    }
}