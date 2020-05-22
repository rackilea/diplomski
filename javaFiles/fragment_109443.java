import java.util.Scanner;

public class GCDFunctionJavaProgram {

public static void main(String[] args) {

    int num1;
    int num2;

    Scanner input = new Scanner(System.in);

    System.out.print("Enter your first number: ");
    num1 = input.nextInt();
    System.out.print("Enter your second number: ");
    num2 = input.nextInt();

    GCDFunction(num1, num2);

}

public static void GCDFunction(int num1, int num2) {
    int div;
    if(num1 > num2){
       div = num2;
    }

   else{ div = num1;}

   while((num1 % div!= 0)||(num2 % div != 0))
   {
   div --;
   }//end of while loop
   System.out.printf("The GCD is %d ", div);
   }