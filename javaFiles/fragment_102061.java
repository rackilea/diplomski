//DAO
@Override
public Person findPersonWithRoles(UUID personId){
    Criteria criteria = sessionFactory.getCurrentSession().createCritiera(Person.class);

    criteria.add(Restrictions.idEq(personId);
    criteria.setFetchMode("roles", FetchMode.SUBSELECT);
}