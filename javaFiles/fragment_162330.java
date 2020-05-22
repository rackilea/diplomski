public static User getGreatestId(EntityManager em){
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<User> cq = cb.createQuery(User.class);
    Root<User> userRoot = cq.from(User.class);  
    Path<Long> pathToId = userRoot.get("id");
    cq.select(userRoot).orderBy(cb.desc(pathToId));
    TypedQuery<User> typed = em.createQuery(cq);
    typed.setMaxResults(1);
    return typed.getSingleResult();
}