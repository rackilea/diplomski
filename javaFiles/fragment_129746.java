public String addProject() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();   
        em.getTransaction().begin();

        String sessionEmail=Util.getEmail();
        Query myQuery = em.createQuery("SELECT u FROM BusinessAccount u WHERE u.email=:email");
        myQuery.setParameter("email", sessionEmail);
        List<BusinessAccount> accounts=myQuery.getResultList();
        BusinessAccount account =accounts.get(0);

        projects.setBusinessAccount(account); //managing both sides
        account.getProjects().add(projects); //managing both sides
        em.persist(projects);
        em.getTransaction().commit();
        em.close();

        return "success";
    }