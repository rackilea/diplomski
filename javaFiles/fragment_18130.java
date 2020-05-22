import java.util.Scanner;

class Newbie
{
    public static void main(String[] arg)
    {
      boolean authorized = true;
      Scanner qk = new Scanner(System.in);
      int Age;
      String ans;

      System.out.println("How old are you?");
      Age=qk.nextInt();
      in.nextLine(); // clear newline char from the buffer
      if(Age < 18) {
        System.out.println ( Age +" is too young! " ); 
        authorized = false;         
      }
      else { // else statement fixes logic error
        System.out.println ( " You can enter. What is your name ? " );
        ans=qk.nextLine();
        if (ans.equals("Jack")) {
          System.out.println ( "Jack, you are not allowed to use this program " );
          authorized = false;         
        }
      }
      if(authorized) {
        // Do program stuff here
      }
    }

}