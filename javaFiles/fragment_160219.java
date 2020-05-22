@Stateful
@LocalBean
public class EJB_A {
}

@Stateful
@LocalBean
public class EJB_B {
  @Inject @SessionScoped
  EJB_A ejb;
}
@ManagedBean
@SessionScoped
public class ManagedBeanA {
   @Inject @SessionScoped
   EJB_A ejb;
}