public List<Asset> retrieveTask(Project project, boolean assigned) {

    DetachedCriteria subquery = DetachedCriteria.forClass(Task.class);

    subquery.add(Restrictions.eq("project", project));
    DetachedCriteria assetCriteria = subquery
        .createCriteria("component")
        .createCriteria("asset").setProjection(Projections.groupProperty("id"));

    Criteria criteria = super.createCriteria();
    if(assigned) {
        criteria.add(Subqueries.propertyIn("id", subquery));
    }
    else {
        criteria.add(Subqueries.propertyNotIn("id", subquery));
    }
    return criteria.list();
}