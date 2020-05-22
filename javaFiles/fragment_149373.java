public class Test 
{ 
    public static void main(String[] args) 
    { 
       Test dataAccess=new Test();
       List<Fruit> FruitList=dataAccess.getAllRecords(Fruit.myType);
       List<User> UserList=dataAccess.getAllRecords(User.myType);
    } 
    <T> List<T> getAllRecords(T cl)
    {
        List<T> list=new ArrayList<T>();
        if(cl instanceof Fruit)
        {
             // Use JDBC and SQL SELECT * FROM fruit
        }
        else if(cl instanceof User)
        {
            // Use JDBC and SQL SELECT * FROM user
        }
        return list;
    }
}
class Fruit
{
    static final Fruit myType;
    static {myType=new Fruit();}
}
class User
{
    static final User myType;
    static {myType=new User();}
}