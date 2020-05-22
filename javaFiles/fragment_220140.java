public class TestApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfiguration.class);

        ctx.registerShutdownHook();

        BeanTwo bean = ctx.getBean(BeanTwo.class);

        bean.testMethod();
    }

}