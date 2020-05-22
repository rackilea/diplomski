@Configuration
 Class C{ 

 @Autowire
 private B b;

     @Bean
     D d(){
       D d = new D();
       //TODO: How do I use instance of B here
      d.someConfiguration(B b);
      return d;
      }
  }