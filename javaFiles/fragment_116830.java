private EntityManager em;
private EntityManagerFactory emf;

public UserDAOBean(EntityManagerFactory emf) {
    this.emf = emf;
    this.em = emf.createEntityManager();
}