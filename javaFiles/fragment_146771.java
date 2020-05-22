@Configuration
    public class TestConfig extends DefaultConfig {

      @Bean
      public MyService myService() {
        return Mockito.spy(new MyServiceImpl());
      }
    }