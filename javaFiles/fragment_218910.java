final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(HDNewsPost.class);
criteria.setFirstResult(startFrom);
criteria.setMaxResults(maxResults);
criteria.addOrder(Order.desc("publicationDate"));

if (code != null) {
    criteria.createAlias("recipientCodes", "rc", CriteriaSpecification.LEFT_JOIN);
    criteria.add(Restrictions.or(Restrictions.isEmpty("recipientCodes"),
        Restrictions.eq("rc.elements", code)));
}

return criteria.list();