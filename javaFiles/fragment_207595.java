User loggedInUser = null;

boolean found = false;
int index = 0;

while (!found)
{
    if (index >= users.size())
        break;

    User user = users.get(index++);

    if (user.getUserName().equals(userName) && user.getPassword().equals(password))
    {
        loggedInUser = user;
        found = true;
    }
}