List<User> userList = new ArrayList<User>();
  while(rs.next()) {
     User user = new User();
     user.setId(rs.getString("user_id"));
     user.setStartDate(rs.getTimestamp("s_date");
     ....
     userList.add(user);
  }
  return userList;