public void deleteAll() {
    try {
        TypedQuery<MyEntity> query = em.createQuery("From MyEntity f", MyEntity.class);
        query.setHint("org.hibernate.cacheable", true);
        List<MyEntity> result = null;
        result = query.getResultList();
        if (!result.isEmpty()) {
            for (MyEntity f : result) {
                em.remove(f);
            }
        }
        em.flush();

    } catch (Exception e) {
        throw new PersistanceException("An error occurred while attempting to delete an instance of an object : " + entityClass, e);
    }
}