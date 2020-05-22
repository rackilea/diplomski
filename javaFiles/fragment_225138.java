@Path("myresource")
@Stateless
public class MyResource {

  @PersistenceContext(unitName="myPersistenceUnit")
  private EntityManager em; 
...