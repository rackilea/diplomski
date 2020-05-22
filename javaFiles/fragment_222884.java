interface performCrud<T>
{
    public void Create(T cl);
    public void delete(T cl);
    public void update(T cl);
    public T read();
}

class newuser implements performCrud<UserDao>{

    @override
    public void Create(UserDao userdao)
    {

    }
    ....
}