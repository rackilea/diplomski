Criteria c = getSession().
        createCriteria(User.class).
        add(Restrictions.like("name", name, MatchMode.ANYWHERE));
c.setMaxResults(1);
List<User> users = c.list();
return users.isEmpty() ? null : users.get(0);