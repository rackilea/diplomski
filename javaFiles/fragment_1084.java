public <T> List<Object> queryWithGroupBy(Class<T> clazz, String property){
    Criteria crit = getSession().createCriteria(clazz);
    crit.setProjection(Projections.projectionList()
            .add(Projections.groupProperty(property), property));
    return crit.list(); 
}