public class User {

public static String User;
public static String Password;

public User() { 
}

public static String getUser() {
    return User;
}

public static void setUser(String user) {
    User = user;
}

public static String getPassword() {
    return Password;
}

public static void setPassword(String password) {
    Password = password;
}

public static boolean Auth(String user, String password){

    if(Password.equals("123456") && User.equals("mansoor")){
        System.out.println("Password: " + Password);
        return true;   
    }
    else {
        return false; 
      }  
   }
}