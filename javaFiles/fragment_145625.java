@Stateless 
@PersistenceContext(name="OrderEM") 
public class MySessionBean implements MyInterface { 
  @Resource SessionContext ctx; 
  public void doSomething() { 
     EntityManager em = (EntityManager)ctx.lookup("OrderEM"); 
     ... 
  } 
}