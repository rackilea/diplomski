public List<User> getWithUsername(String username){

    Criteria criteria = getSession().createCriteria(IWUser.class)
    .add(Restrictions.like("username", username))
    .setFetchMode("userRole", FetchMode.EAGER)
    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

    return criteria.list();

}