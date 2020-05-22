private EntityManager em;
    @PersistenceContext(unitName = "mymoneyunit")
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
    ...
}