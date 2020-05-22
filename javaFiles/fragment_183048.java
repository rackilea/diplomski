try{
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Producto> query = cb.createQuery(Producto.class);

    CriteriaQuery<Long> queryCount = cb.createQuery(Long.class);
    Root<Producto> entityRoot = queryCount.from(query.getResultType());
    queryCount.select(cb.count(entityRoot));

    Root<Producto> entity = query.from(Producto.class);
    TypedQuery<Producto> tq;
    //And the rest of the code is the same as the original one.
    //...
}