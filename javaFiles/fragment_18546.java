import java.util.Scanner;
public class HomeworkScanner
{

 public static void main(String args[])
 {

        int x, y, z, a, result;
        Scanner Keyboard;
        Keyboard = new Scanner(System.in);
        System.out.println("a = ( x + y ) * z");
        System.out.println("Enter first number for x:");
        x = Keyboard.nextInt(); //
        System.out.println("Enter second number for y:");
        y = Keyboard.nextInt(); //
        System.out.println("Enter third number for z:");
        z = Keyboard.nextInt(); //
        result=a=( x + y ) * z;
        System.out.println("result is :"+result);
     }
}