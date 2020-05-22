public static long getRowCount(Class<?> rootClass) {
    CriteriaBuilder cb = EM.getCriteriaBuilder();
    CriteriaQuery<Long> query = cb.createQuery(Long.class);

    Expression<?> root = query.from(rootClass);
    query.select(cb.count(root));

    return EM.createQuery(query).getSingleResult();
}

/*****/
DbTools.getRowCount(PlacesEntity.class);