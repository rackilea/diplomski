@Stateless 
public class WidgetDAO implements WidgetDAOLocal {
  @PersistenceContext 
  private EntityManager em;

  public EntityManager getEntityManager() {
    return em;
  } 

  public Widget updateWidget(Widget widget) throws Exception {
    return getEntityManager().merge(widget);
  }