public class ViewItemDao {
  @PersistenceContext
  protected EntityManager em;
  public ViewItemDao(EntityManager em) {
    this.em = em;
  }