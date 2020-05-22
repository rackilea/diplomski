@Component
public class SomeObject {

  @PostConstruct
  public void init() throws Exception {
    throw new Exception("SomeObject init threw exception");
  }
}

public class ObjConstructionFailureAnalyzer extends 
                     AbstractFailureAnalyzer<BeanCreationException> {

  @Override
  protected FailureAnalysis analyze(Throwable rootFailure, 
                        BeanCreationException cause) {
    System.out.println("\n===>ObjConstructionFailureAnalyzer::analyze()\n");
    String desciption = "Object creation failed, [Reason]: " + 
                                                     cause.getMessage();
    String action = "Please handle exceptions in your init methods";
    return new FailureAnalysis(desciption, action, cause);
  }
}