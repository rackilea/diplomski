package javaapplication6 ;
import java.util.*;

public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in) ;
        System.out.println ("Please enter your user name!");

        String userName = in.nextLine ();
        System.out.println("please enter the passcode" + userName + ".");

        int passcodeFromUser = in.nextInt ();
        int passcode = 7001 ;

        if (passcodeFromUser == passcode) 
        {
        System.out.println("welcome" + userName + "!" );
        }        
        else
        {
        System.out.println("Acess Denied");        
        }
    }

}