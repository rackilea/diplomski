public List<Solution> findSolutionsWithTags(String[] requiredTags) {
    final String parentAlias = "sol";
    final String childAlias = "subSol";
    final String collFieldAlias = "t";
    final String tagValueField = collFieldAlias + ".name";

    DetachedCriteria subquery = DetachedCriteria.forClass(Solution.class, childAlias)
            // Throws ClassCastException; apparently sol.id isn't replaced with an ID value?
            // Problem should be due to following line
            //.add(Restrictions.eq("id", parentAlias + ".id"))
            // Use eqProperty instead
            .add(Restrictions.eqProperty(childAlias + ".id", parentAlias + ".id")) 
            .createAlias("tags", collFieldAlias) //
            .add(Restrictions.in(tagValueField, requiredTags)) //
            .setProjection(Projections.count(tagValueField));
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Solution.class, parentAlias)
            .add(Subqueries.eq((long) requiredTags.length, subquery));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    return criteria.list();
}