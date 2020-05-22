@Configuration
 Class C{ 

     @Bean
     D d(B b){
       D d = new D();
       //TODO: How do I use instance of B here
      d.someConfiguration(B b);
      return d;
      }
  }