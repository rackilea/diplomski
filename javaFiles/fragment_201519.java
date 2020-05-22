@Component
public class HibernateListenerRegistrar {
   @PersistenceUnit
   private EntityManagerFactory entityManagerFactory;

   @Autowired
   private AuditEventListener auditEventListener;

   @PostConstruct
   public void registerListeners() {
      if(entityManagerFactory instanceof HibernateEntityManagerFactory) {
          final HibernateEntityManagerFactory  hibernateEntityManagerFactory = (HibernateEntityManagerFactory) entityManagerFactory;
          final SessionFactoryImpl sessionFactory =  (SessionFactoryImpl) hibernateEntityManagerFactory.getSessionFactory();
          final EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
          registry.getEventListenerGroup(EventType.PERSIST).appendListener(auditEventListener);
          registry.getEventListenerGroup(EventType.MERGE).appendListener(auditEventListener);
          registry.getEventListenerGroup(EventType.DELETE).appendListener(auditEventListener);
          registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(auditEventListener);
          // register other events here
      }
    }
}