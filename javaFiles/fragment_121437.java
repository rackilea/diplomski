public class Users
{
  private User getUserById(List<User> users, int id)
  {
    for (User user : users)
    {
      if (user.getId() == id)
      {
        return user;
      }
    }
    return null;
  }

  public void removeUsers()
  {
    List<User> users = new ArrayList<User>();
    users.add(new User(1, "aaa"));
    users.add(new User(2, "bbb"));
    users.add(new User(3, "ccc"));
    users.add(new User(4, "ddd"));
    users.add(new User(5, "eee"));
    users.add(new User(6, "fff"));
    users.add(new User(7, "ggg"));

    List<Integer> removeUsers = new ArrayList<Integer>();
    removeUsers.add(3);
    removeUsers.add(6);
    removeUsers.add(1);
    removeUsers.add(4);


    for (Integer integer : removeUsers)
    {
      User userToRemove = getUserById(users,integer);
      if (userToRemove != null)
      {
        users.remove(userToRemove);
      }
    }

    for (User user : users)
    {
      System.out.println(user.getId() + " " + user.getName());
    }

  }

  public static void main(String[] args)
  {
    Users users = new Users();
    users.removeUsers();
  }

}