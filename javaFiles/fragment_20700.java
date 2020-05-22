// search functionality
        try {
            EntityManager em = hibernate.getSessionFactory().createEntityManager();
            FullTextEntityManager  fullTextEntityManager = Search.getFullTextEntityManager(em);

            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }