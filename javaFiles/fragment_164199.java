import java.util.ArrayList;
import java.util.Scanner;
public class FruitApril {
public static void main(String[] args) {

 TheMenu();  
}
public static void TheMenu()
{
String Customer[] = new String[10]; 
Scanner input = new Scanner(System.in);
ArrayList<String> fruits = initFruits();


String option; 
do {   // loop back to here as long as Q isn't selected           
System.out.println("\nMenu");
System.out.println("V: Views all fruit");
System.out.println("R: To reserve fruit"); 
System.out.println("Q: To exit");

option = input.next();  

if (option.charAt(0) == 'V' ) 
{ 
    viewAllFruit(fruits,Customer);
} 


if (option.charAt(0) == 'R' ) 
{ 
    reserveFruit(fruits,Customer);
}
if(option.charAt(0) == 'Q') // added this condition
{
    System.exit(0);
}

}while (option.charAt(0) == 'Q');