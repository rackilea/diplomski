@Stateless
public class AnalyzerResultSaver
{
    @PersistenceContext(unitName="QIS") 
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    private void save(AnalyzerResult alyzres) throws PrdItemNotFoundException {
        Some s = em.find(Some.class, somepk);
        s.setSomeField("newvalue");
        // SQL Exception happens after leaving this method
    }
}