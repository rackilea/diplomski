@Override
public Optional<Users> findByUsername(String username) {
    String hql = "select e from " + Users.class.getName() + " e where e.login = ?";
    TypedQuery<Users> query = entityManager.createQuery(hql, Users.class).setParameter(0, username);
    List<Users> users = query.getResultList();
    return users.isEmpty() ? Optional.empty() : Optional.of( users.get(0) );
}