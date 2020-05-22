int index = -1;
while (++index < users.size())
{
    User user = users.get(index);

    if (user.getUserName().equals(userName) && user.getPassword().equals(password))
    {
        loggedInUser = user;
        break;
    }
}