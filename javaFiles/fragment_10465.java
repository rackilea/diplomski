public void insert() {
    for (int i = 0; i < 1000; ++i) {
        Item item = new Item();
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        em.persist(item);
        tx.commit();
        em.clear();
        em.close();
        tx=null;
        em=null;
    }
}