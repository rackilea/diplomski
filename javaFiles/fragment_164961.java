CriteriaBuilder builder = em.getCriteriaBuilder();
CriteriaQuery<User> criteria = builder.createQuery(Fornecedor.class);

Root<User> root = criteria.from(User.class );
criteria.select(root);

Fetch<User, UserRoles> userRolesFetch = root.fetch("userRolesList", JoinType.INNER);
Fetch<UserRoles, Role> roleFetch = userRolesFetch.fetch("role", JoinType.INNER);

List<User> users = em.createQuery(criteria).getResultList();