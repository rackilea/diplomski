public class Test 
{ 
    public static void main(String[] args) throws InstantiationException, IllegalAccessException 
    { 
       Test dataAccess=new Test();

       List<Fruit> FruitList=dataAccess.getAllRecords(Fruit.class);

       List<User> UserList=dataAccess.getAllRecords(User.class);

    } 
    <T> List<T> getAllRecords(Class<T> cl) throws InstantiationException, IllegalAccessException
    {
        T inst=cl.newInstance();
        List<T> list=new ArrayList<T>();
        if(inst instanceof Fruit)
        {
             // Use JDBC and SQL SELECT * FROM user
        }
        else if(inst instanceof User)
        {
            // Use JDBC and SQL SELECT * FROM fruit
        }
        return list;
    }
}