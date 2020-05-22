List<User> newUsers = new ArrayList<User>();
for (User user : users)
{
    if (user.isActive())
    {
        newUsers.add(user);
    }
}
users = newUsers;