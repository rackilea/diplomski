String queryString = "Select {user.*}, (select max(submitted) from posts where post.user_id = user.id) MAX_POST from users user";
SQLQuery query = getSession().createSQLQuery(queryString);
query.addEntity("user", User.class);
query.addScalar("MAX_POST", Hibernate.DATE);

List results = query.list();
List<User> users = new ArrayList();
for (Object item : results) {
    Object[] element = (Object[]) item; 
    User user = (User)element[0];
    user.setMaxPost((Date)element[1]);
    users.add(user);
}