@Configuration
public class MyConfig {

   @Bean
   public MyBean getMyBean() {
     MyBean myBean = ...

     return myBean;
   }
}

...

@Component
public class AnotherClass {

  @Autowired
  private MyBean myBean;

  ...
 }