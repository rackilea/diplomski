public void test() {
    EntityManager em = entityManagerFactory.createEntityManager();
    PersistenceUnitUtil unitUtil =
        em.getEntityManagerFactory().getPersistenceUnitUtil();

    em.getTransaction().begin();
    Organization org = em.find(Organization.class, 1);
    em.getTransaction().commit();

    Assert.assertTrue(unitUtil.isLoaded(org));
    // users is a field (Set of User) defined in Organization entity
    Assert.assertFalse(unitUtil.isLoaded(org, "users"));

    initializeCollection(org.getUsers());
    Assert.assertTrue(unitUtil.isLoaded(org, "users"));
    for(User user : org.getUsers()) {
        Assert.assertTrue(unitUtil.isLoaded(user));
        Assert.assertTrue(unitUtil.isLoaded(user.getOrganization()));
    }
}

private void initializeCollection(Collection<?> collection) {
    // works with Hibernate EM 3.6.1-SNAPSHOT
    if(collection == null) {
        return;
    }
    collection.iterator().hasNext();
}