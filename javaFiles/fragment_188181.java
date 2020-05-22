private static <T extends SuperClass> List<T> queryForClass(Class<T> myClass) {

    Query q = em.createQuery("SELECT p FROM SuperClass p WHERE TYPE(p) = :myClass");
    q.setParameter("myClass", myClass);
    List<? extends SuperClass> resultList = q.getResultList();

    return (List<T>) resultList;
}