public class Car{
     private Motor motor;

     @Autowired
     private ApplicationContext applicationContext;

     @PostConstruct
     public void init() {
        try {
            motor = applicationContext.getBean( Motor.class );
        } catch( NoSuchBeanDefinitionException e ) {
            motor = new DefaultMotor();
        }
     }
}