@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void testMethod1(String query) {

    Query q = entityManager.createNativeQuery(query);
    q.setHint(QueryHints.NATIVE_LOCKMODE, LockModeType.NONE);
    List<Object[]> result =  q.getResultList();
}