@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class Repository {
   @PersistenceContext(unitName="blah", type = PersistenceContextType.TRANSACTION)
   private EntityManager em;
}