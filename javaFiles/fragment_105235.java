@Configuration
 Class C{ 

 private B b;

  @Autowire
  public C(B b){
   this.b=b;
  }

     @Bean
     D d(){
       D d = new D();
       //TODO: How do I use instance of B here
      d.someConfiguration(B b);
      return d;
      }
  }