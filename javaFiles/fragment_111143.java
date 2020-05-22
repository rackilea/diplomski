for (int i = users.size()-1; i >= 0; i--)
{
    if (!users.get(i).isActive())
    {
        users.remove(i);
    }
}