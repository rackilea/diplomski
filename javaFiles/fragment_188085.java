public ReferenceCodeMetaData[] getMatchingWithJPQL(EntityManager em,
                                                   Integer siteId,
                                                   String codeType) {
    String jpql =  "SELECT r FROM ReferenceCodeMetaData r where siteId = :siteId AND codeType = :codeType";
    TypedQuery<ReferenceCodeMetaData> query = em.createQuery(jpql, ReferenceCodeMetaData.class);

    query.setParameter("siteId", siteId);
    query.setParameter("codeType", codeType);
    List<ReferenceCodeMetaData> result = query.getResultList();

    return result.toArray(new ReferenceCodeMetaData[result.size()]);
}

public ReferenceCodeMetaData[] getMatchingWithCriteriaAPI(EntityManager em,
                                                          Integer siteId,
                                                          String codeType) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<ReferenceCodeMetaData> cq = cb.createQuery(ReferenceCodeMetaData.class);
    Root<ReferenceCodeMetaData> root = cq.from(ReferenceCodeMetaData.class);

    cq.select(root)
        .where(cb.and(
            cb.equal(root.get("siteId"), cb.parameter(Integer.class, "siteId")),
            cb.equal(root.get("codeType"), cb.parameter(String.class, "codeType"))));

    TypedQuery<ReferenceCodeMetaData> query = em.createQuery(cq);

    query.setParameter("siteId", siteId);
    query.setParameter("codeType", codeType);
    List<ReferenceCodeMetaData> result = query.getResultList();
    return result.toArray(new ReferenceCodeMetaData[result.size()]);
}

public ReferenceCodeMetaData[] getMatchingWithJHibernateCriteria(EntityManager em, 
                                                                 Integer siteId, 
                                                                 String codeType) {
    HibernateEntityManager hem = em.unwrap(HibernateEntityManager.class);
    Session session = hem.getSession();
    // If you use some older version of Hibernate, then unwrap method is not 
    // available and you can use following instead of two lines above:
    // Session session = (Session) em.getDelegate();


    List<ReferenceCodeMetaData> result = session.createCriteria(ReferenceCodeMetaData.class)
        .add(Restrictions.eq("siteId", siteId) )
        .add(Restrictions.eq("codeType", codeType))
    .list();
    return result.toArray(new ReferenceCodeMetaData[result.size()]);
}