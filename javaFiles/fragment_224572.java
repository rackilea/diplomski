import java.util.*;

public class StringDemo {
public static void main(String[] args) {
            Scanner console = new Scanner(System.in);

            // enter a string: 
            System.out.println("Enter a string: "); 
            String dog = console.nextLine();
            dog = dog.toUpperCase();
            System.out.println(dog + " has " + dog.length() +
               " letters and starts with " + dog.substring(0, 1));





            // enter another string:
            System.out.println("Enter another string: "); 
            String cat = console.nextLine();
            cat = cat.toUpperCase();
            System.out.println(cat + " has " + cat.length() +
               " letters and starts with " + cat.substring(0, 1)); 

           // check contents here
          if(dog.endsWith("?"))
              System.out.println("Input Strings ends in a question mark ");

    }
}