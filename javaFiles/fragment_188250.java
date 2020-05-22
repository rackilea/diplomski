public class UserContainer 
{
    private final Map<K, User> usersByKey1=new HashMap<K1, User>(1.7*finalSize);

    public void addUser(User user)
    {
        synchronized(this)
        {
            this.usersByKey1.put(key1, user);
            ...
        }
    }

    public void User getUserByKey1(Key1 key1)
    {
        return this.usersByKey1(key1);
    }

    public void removeUser(User user)
    {
        synchronized(this)
        {
            this.usersByKey1.remove(key1);
            ...
        }
    }
}