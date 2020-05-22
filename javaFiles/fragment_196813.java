import java.util.Scanner;

public class TwentyOneSticks { 
public static void main(String[] args) { 
 System.out.println("What is your name?");
 Scanner input = new Scanner(System.in);   <--- moved it here
 String userName = input.nextLine();
 int numofSticks = 21;

  //Scanner take = new Scanner(System.in);   <-- what is use of this?
  System.out.println("Would you like to go first? (Y/N)");
  String goFirst = input.nextLine();