private EntityManagerFactory emf;

@PersistenceUnit
public void setEntityManagerFactory(EntityManagerFactory emf) {
    this.emf = emf;
}
// ... later in code
    EntityManager em = emf.createEntityManager();