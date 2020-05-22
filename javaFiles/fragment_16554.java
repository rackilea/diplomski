import java.util.*;

  public class lab2q2 {

  public static void main(String[] args) {

    String RegularExp = "((Mr|Ms))?[A-Z][a-z]+([A-Z]([a-z]+\\.))?([A-Z](a-z)+)"; 
    Pattern pattern = Pattern.compile(RegularExp);
    Scanner keyboard = new Scanner(System.in);



    for(int i = 0; i< 11; i++)
    {
            System.out.println("Please enter a name: ");

            String inputString = keyboard.nextLine(); 
            Matcher matcher = pattern.matcher(inputString );
            if(!matcher.matches()) {
                System.out.println("Name: " + inputString);
            }
            else
            {
                System.out.println("Invalid name.");
            }
    }

    keyboard.close(); 

    }// end method main
}//