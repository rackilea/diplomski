EntityManager em = emf.createEntityManager();
try {
    em.getTransaction().begin();
    Parent p = new Parent();
    ChildX childX = new ChildX();
    childX.setParent(p);
    em.persist(p);
    em.persist(childX);
    em.getTransaction().commit();
} finally {
    em.close();
}