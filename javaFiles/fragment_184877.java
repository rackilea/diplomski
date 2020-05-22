List<User> users = new ArrayList<User>();
while (resultSet.next()) {
    User user = new User();
    user.setId(resultSet.getLong("id"));
    user.setName(resultSet.getString("name"));
    user.setBirthdate(resultSet.getDate("birthdate"));
    users.add(user);
}
return users;