public static User getGreatestId(EntityManager em){
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<User> cq = cb.createQuery(User.class);       
    Root<User> userRoot = cq.from(User.class);  
    Path<Long> pathToId = userRoot.get("id");       
    Subquery<Long> subquery = cq.subquery(Long.class);
    Root<User> subRoot = subquery.from(User.class);
    Path<Long> subPathToId = subRoot.get("id");             
    subquery.select(cb.max(subPathToId));       
    cq.select(userRoot).where(cb.equal(pathToId, subquery));
    TypedQuery<User> typed = em.createQuery(cq);       
    return typed.getSingleResult();
}