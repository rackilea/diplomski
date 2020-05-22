public List<User> getAllUsers() {
    Criteria query = sessionFactory.getCurrentSession().createCriteria(User.class);
    query.setProjection(Projections.projectionList()
        .add(Projections.property("firstName"), "firstName")
        .add(Projections.property("lastName"), "lastName"))
    .setResultTransformer(Transformers.aliasToBean(User.class));

    return query.list();
}