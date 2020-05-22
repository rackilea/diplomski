public User findUser(String login) {
    User user = null;
    final SearchCriteria criteria = buildSearchCriteria(login); // construct a search criteria from the login parameter
    List<User> users = findAll(criteria);  
    if (null != users) {
       assert (users.size() == 1) : "More than one user was matched - login must be unique.";
       user = users.get(0);
    }
    return user;
}