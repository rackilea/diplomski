@Configuration
@ConditionalOnProperty(value = "my.property", havingValue = "true")
 public class MyConfiguration {

  @Bean
  public SubConfig1 getSubConfig1() {
     return new SubConfig1();
    }

  @Bean
  public SubConfig2 getSubConfig2() {
     return new SubConfig2();
    }

    static class SubConfig1 {
    }


   static class SubConfig2 {
   }


 }