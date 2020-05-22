Query q = session.createSQLQuery("select firstname, lastname from user");
//when it's native query, returned list is a list of arrays, and each array is a row
List<Object[]> ls = (List<Object[]>) q.list();
//you should return list of User object from this method, so need to create one
List<User> users = new ArrayList<User>();
for (Object[] row : ls) { // go throw each row
    User user = new User(); // instantiate a new User
    user.setFirstName((String) row[0]); // set it's first name
    user.setLastName((String) row[1]);  // set it's last name
    users.add(user); // add the User instances to the list "users"
}
return users; //return the list we created