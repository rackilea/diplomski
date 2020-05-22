public Users getUser(int userId) 
{
   return DatabaseClient.getInstance(context).getAppDatabase()
      .usersDao().getUser(username);
}
 public List<Users> getAllUser() 
 {
  return DatabaseClient.getInstance(context).getAppDatabase().
    usersDao().getAll();
 }
 public void insert() 
   {
  User user1=new User();
  user1.setUserName("jack");
  user1.setUserAddress("usa");

    DatabaseClient.getInstance(context).getAppDatabase().usersDao().insert(user1);
 }