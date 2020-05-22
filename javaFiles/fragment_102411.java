import java.io.* ;
    class Tut1 {
     public static void main(String args[])
     {
               InputStreamReader istream = new InputStreamReader(System.in) ;
               BufferedReader bufRead = new BufferedReader(istream) ;

               System.out.println("Welcome To My First Java Program");
          try {
               System.out.println("What is the username?");
               String username= bufRead.readLine();

               System.out.println("What is the password?");
               String password = bufRead.readLine();

               //if(username.equal("**") && password.equal("**")){

               System.out.println("Access Granted");

               //To clear screen
               System.out.print("\033[H\033[2J");
               System.out.flush();

               System.out.println("Welcome\""+ username +"\"");

               //}
          }
          catch (IOException err) {
               System.out.println("Error reading line");
          }
     }  
}