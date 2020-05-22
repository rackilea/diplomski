@Stateless
public class PriceManagementBean implements PriceManagement {

    @PersistenceContext
    private EntityManager em;

    public List<PriceStep> getAllPriceSteps() {
         Query query =  em.createNamedQuery("allPriceSteps");
         return query.getResultList();
     }
}