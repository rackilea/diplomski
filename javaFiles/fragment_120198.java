public class helloworld2
{
    public static void main(String[] arg)
    {
        Scanner q = new Scanner(System.in);
        long Pass;
        boolean auth = true;
        boolean rightPassword = false;
        while(!rightPassword){//repeat until passwort is correct
          System.out.println("Enter Password :");
          Pass = q.nextLong();

          if ( Pass != 1234 )
          {
            System.out.println("Wrong Password!");
            auth = false;
          }
          else
          {
            rightPassword = true;//let the loop finish
            System.out.println("Password Confirmed.");
            auth = true;
          }
        }
        // Here do what you want to do
        //because here the user has entered a right password                 
    }
}