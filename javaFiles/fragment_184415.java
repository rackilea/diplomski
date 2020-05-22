// deletes users with ID 1, 2
List<Object[]> ids = new ArrayList<>();
ids.add(new Object[]{1L}); // user ID 1
ids.add(new Object[]{2L}); // user ID 2
jdbcOperations.batchUpdate("delete from user where id = ?", ids);

// deletes users 'Paul Muller' and 'Jack Jones'
List<Object[]> users = new ArrayList<>();
users.add(new Object[]{"Paul", "Muller"});
users.add(new Object[]{"Jack", "Jones"});
jdbcOperations.batchUpdate("delete from user where firstname = ? and lastname = ?", users);