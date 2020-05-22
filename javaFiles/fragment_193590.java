public class SomeSpringConfigTest {

    @Configuration
    static class ContextConfiguration {

        @Bean
        public MyService monitoringService() {
            return new MyService();
        }
    }
}