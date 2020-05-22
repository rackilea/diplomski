@Component
public class Consumer {

     @Autowired 
     private final ProcessorFactory processorFactory;


      public void method() {
        Processor p = processorFactory.createProcessor("some random per request data");
        p.blablbaba();
      }
}