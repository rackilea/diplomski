@SpringBootApplication
public class So48774170Application {

    public static void main(String[] args) {
        SpringApplication.run(So48774170Application.class, args).close();
    }

    @Configuration
    @EnableTransactionManagement
    public static class Config {

        @Bean
        public ApplicationRunner runner(JmsTemplate template, Foo foo) {
            return args -> {
                template.convertAndSend("foo", "bar");
                try {
                    foo.test();
                }
                catch (RuntimeException e) {
                    // no op
                }
                System.out.println("OK:" + foo.test());
            };
        }

        @Bean
        @Primary
        public ConnectionFactory cf() {
            return new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
        }

        @Bean
        public CachingConnectionFactory ccf(ConnectionFactory cf) {
            return new CachingConnectionFactory(cf);
        }

        @Bean
        public JmsTemplate template(CachingConnectionFactory ccf) {
            return new JmsTemplate(ccf);
        }

        @Bean
        public PlatformTransactionManager transactionManager(CachingConnectionFactory ccf) {
            return new JmsTransactionManager(ccf);
        }

    }

}