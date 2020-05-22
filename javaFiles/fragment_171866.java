@OnOpen
    public void open(Session session, Endpoint config){
        emf = Persistence.createEntityManagerFactory(""); //TODO add persistence unit reference here
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @OnClose
    public void close(Session session, CloseReason reason){
        //if session is closing and information still exists in the database; remove it
        if (!wsu.equals(null)){
            tx.begin();
            em.remove(wsu);
            tx.commit();
        }
        em.close();
        emf.close();
    }