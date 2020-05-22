public Set<State> getStatesByCountry(String countryName) {
    Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Harbor.class, "harbor");
    criteria.setProjection(Projections.distinct(Projections.property("harbor.address.state.name")));
        criteria.add(Restrictions.eq("harbor.address.country.name", countryName).ignoreCase());
        criteria.add(Restrictions.isNotNull("harbor.address.state.name"));
        states.addAll(criteria.list());
}