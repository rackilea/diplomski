@Component
public class BatchProcessProcessor {

   private MyService service;

   @Autowired // This is correct, you can autowire collaborators
   public DeploymentProcesser(MyService service){
       this.service= service;
   }

   @Bean // THIS IS NOT CORRECT
   @StepScope
   public DeploymentProcesser processor() {
      return new DeploymentProcessor(service);
   } 
}