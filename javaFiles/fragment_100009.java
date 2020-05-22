public class Exercise6 {
    public static void main(String[] args) {
    String user = Input.askString("Username:");
    String pass = Input.askString("Password:");
    if (user.equals("joe") || pass.equals("guess"))
        System.out.println("Welcome, joe!");
     else
        System.out.println("Incorrect username or password.");    
    }
}