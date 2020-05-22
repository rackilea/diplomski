@Stateless(name="UtilityEJB", mappedName="UtilityEJBGlobal")
public class UtilityEJB 
{

    @PersistenceContext(unitName = "PRIMARY_PERSISTENCE_UNIT")
    public EntityManager em;

    //other stuff   ......
}