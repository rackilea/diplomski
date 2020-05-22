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
                        m.getMessageProperties().setReplyTo("bar");
                        System.out.println("Adding header to outgoing message with payload: " + new String(m.getBody()));
                        return m;
                    });
                }
                else if (bean instanceof AbstractRabbitListenerContainerFactory) {
                    ((AbstractRabbitListenerContainerFactory<?>) bean).setAfterReceivePostProcessors(m -> {
                        m.getMessageProperties().setHeader("qux", "fiz");
                        System.out.println("Adding header to incoming message with payload: " + new String(m.getBody()));
                        return m;
                    });
                    ((AbstractRabbitListenerContainerFactory<?>) bean).setBeforeSendReplyPostProcessors(m -> {
                        m.getMessageProperties().setHeader("foo", "baz");
                        m.getMessageProperties().setReplyTo("bar");
                        System.out.println(
                                "Adding header to outgoing reply message with payload: " + new String(m.getBody()));
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
    @SendTo
    public String listen1(String in, @Header("foo") String header) {
        System.out.println(in + header);
        return in.toUpperCase();
    }

    @RabbitListener(queues = "bar")
    public void listen2(String in) {
        System.out.println(in);
    }

}