public class Main {
    public static void main(String... args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);  // create Spring context that enables AOP under the hood
        TestClass testObject = context.getBean(TestClass.class); // we get reference to TestClass instance from context; calling on a plain new instance wouldn't work
        testObject.foo(); // prints "bar" !
    }

    @EnableAspectJAutoProxy // enables AOP support
    @Configuration
    public static class TestConfiguration {
        @Bean public TestClass testClass() { return new TestClass(); }
        @Bean public ReplacingAspect aspect() { return new ReplacingAspect(); } // enables our ReplacingAspect
    }
}