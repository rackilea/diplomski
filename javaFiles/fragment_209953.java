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


    public class MyMain {

        public static void main(String[] args) {
            employee e = new employee();
            e.login();  
        }

    }

 /*
Output : 
---------------
Username: MHM
Password: 15234785

*/