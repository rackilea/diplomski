@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public <T> void updatetBatch(List<T> list) {
    if (list == null || list.isEmpty())
        throw new NullPointerException();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    final int BATCHLIMIT = 50;

    try {
        int size = list.size();

        for (int i = 0; i < size; i++) {
         Object primaryKeyObj = this.getPrimaryKey(list.get(i));
             //Using find as it will make entity managed.
        T entityObject = list.get(i);
            Object found = entityManager.find(entityObject.getClass(), primaryKeyObj);
            if(found!=null) {

                entityManager.merge(entityObject);
        } else{
        entityManager.persist(entityObject);
        }   
            if (i % BATCHLIMIT == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        entityManager.close();
    }
}
private Object getPrimaryKey(Object object) {
    return entityManagerFactory.getPersistenceUnitUtil().getIdentifier(object);
}