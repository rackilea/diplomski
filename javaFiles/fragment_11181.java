@SpringBootApplication
public class So44456388Application {

    public static void main(String[] args) {
        SpringApplication.run(So44456388Application.class, args);
    }

    public static class Evaluator {
        public static boolean getexenabled() {
            //your logic here
            return true /*false*/;
        }
    }

    @Component
    @ConditionalOnExpression("#{T(com.stackoverflow.so44456388.So44456388Application$Evaluator).getexenabled()}")
    public static class RichBean {
        @PostConstruct
        private void init() {
            System.out.println("RichBean");
        }
    }
}