@Service
public class ServiceXyz {

  @Autowired
  private ApplicationProperties applicationProperties;

  public boolean methodAbc(ClassA classA) {
    return classA.methodA(applicationProperties) && otherStuff();
  }
}