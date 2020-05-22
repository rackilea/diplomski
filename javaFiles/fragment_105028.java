public void yourMethod(){
    final EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    // do your stuff here
    entityManager.getTransaction().commit();
    entityManager.close();
}