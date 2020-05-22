List<User> users = null;

mgr = getPersistenceManager();
Query query = mgr.newQuery(User.class); // Will query all from User class. Replace User with your class

users = (List<User>) query.execute();