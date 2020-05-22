import java.util.*;
public class HelloWorld{

public static void main(String []args){
    Scanner sc = new Scanner(System.in);
    int input;
    while (true){
        if (sc.hasNextInt()){
             input = sc.nextInt(); // Assign the next integer to a variable
             if (input  <= 301  && input >= 1){ // Check if integer meets condition
                   break; // Condition met, break out of loop
            }
        }else{
              sc.next();
        }
        System.out.println("Invalid Input. Please enter a valid number between 1 and 301: ");
    }
}