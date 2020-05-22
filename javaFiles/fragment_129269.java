public class UserDAOFactory{

    public static UserDAO getUserDAO(String type){ 
        if (type.equalsIgnoreCase("mysql")){
            return new UserDAOMySQLImpl();
        }else{
            return new UserDAOMSSQLImpl();
        }
    }
}