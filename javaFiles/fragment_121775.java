@Override
public boolean equals(Object other)
{
    User user = (User)other;
    if(user.getName().equals(name) && user.getId().equals(id))
        return true;
    else
        return false;
}