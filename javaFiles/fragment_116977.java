@Configuration
public class ProcessorFactory {

     @Autowired
     private final SomeDependency dep1; 

     @Autowired
     private final SomeDependency2 dep2;

     @Bean(autowireCandidate = false)
     @Scope("prototype") 
     public Processor createProcessor(String requestData) {
        return new Processor(requestData, dep1, dep2);
    }
}