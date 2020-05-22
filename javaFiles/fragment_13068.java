@Configuration
 public static class TestConfig {

   @Bean
   private EmailService emailService() {
       return Mockito.mock(EmailService.class);
   }

   //Assuming that you have constructor injection.
   @Bean
   public UserService userService() {
     return new UserService(emailService());
   }
}