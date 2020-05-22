package users;


class Account{
  public String username;
  public String password;
}

class employee{

  public void login() {
    Account a = new Account();
    a.username = "MHM";
    a.password = "15234785";
    System.out.println("Username: " + a.username);
    System.out.println("Password: " + a.password);
  }
}

public class MyMainClass{
   public static void main(String [] args){
    // block of code... 
  }
}