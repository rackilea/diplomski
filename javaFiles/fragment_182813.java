@Configuration
@EnableRetry
public class So40308025Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(So40308025Application.class);
        System.out.println(context.getBean(SpringRetryWithHystrixService.class).getStatus());
        context.close();
    }

    @Bean
    public SpringRetryWithHystrixService service() {
        return new SpringRetryWithHystrixService();
    }

}