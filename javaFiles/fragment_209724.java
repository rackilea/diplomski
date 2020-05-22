@Stateless
@EJB(beanInterface=FoodServiceInterface.class, name="FoodServiceBean")
public class FoodServiceBean implements FoodServiceInterface {    

@PersistenceContext(unitName="testPU")
private EntityManager em;

private FoodFacade facade;

public FoodServiceBean()
{

}

@PostConstruct
public void init() {
    this.facade = new FoodFacade(Food.class);
    this.facade.setEntityManager(em);
}