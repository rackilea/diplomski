@SpringBootApplication
public class So56155062Application {

    public static void main(String[] args) {
        SpringApplication.run(So56155062Application.class, args);
    }

    @Bean
    public static BeanPostProcessor bpp() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof RabbitTemplate) {
                    ((RabbitTemplate) bean).setBeforePublishPostProcessors(m -> {
                        m.getMessageProperties().setHeader("foo", "baz");
                        return m;
                    });
                }
                return bean;
            }

        };

    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template) {
        return args -> template.convertAndSend("foo", "bar");
    }

    @RabbitListener(queues = "foo")
    public void listen(String in, @Header("foo") String header) {
        System.out.println(in + header);
    }

}