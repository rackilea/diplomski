public List<Products> findAll() {
    return em.createQuery("select object(o) from Products as o").getResultList();
}

public List<Products> findRange(int[] range) {
    ...
    return q.getResultList();
}