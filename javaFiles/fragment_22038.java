@Component
public class WithAllMyInterfaceImpls {

  @Autowire
  List<MyInterface> allBeansThatImplementTheMyInterface;

}