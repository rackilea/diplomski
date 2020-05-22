import java.util.Scanner;

public class Lame {
    public static void main (String args[])
    {
        while(true) {
         System.out.println("Welcome to robo lame tester 1.1, is your name Connor? Yes or no?");
         Scanner input = new Scanner(System.in);
         String sweg = input.nextLine();
         if(sweg.equals("stop"))
             return;
         if (sweg.equals("Yes"))
              System.out.println("You are lame");
         else 
              System.out.println("You passed, you aren't lame");
        }
    }
}