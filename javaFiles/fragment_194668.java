public List<Locations> getLocationsList() {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();   
    em.getTransaction().begin();

        String sessionEmail=Util.getEmail();
        Query myQuery = em.createQuery("SELECT u FROM BusinessAccount u WHERE u.email=:email");
        myQuery.setParameter("email", sessionEmail);

        List<BusinessAccount> userList=myQuery.getResultList();         
        BusinessAccount account =userList.get(0);

        //This line refreshes the account object with the new values from the database and solves the problem that I was having
        em.refresh(account);

        locationsList=account.getLocations();
        em.getTransaction().commit();
        em.close();

        return locationsList;

    }