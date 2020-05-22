@Autowired
private EntityManagerFactory entityManagerFactory;

@PostConstruct
public void registerListeners() {
    SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    ...
}