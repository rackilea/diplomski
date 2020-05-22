import java.util.Scanner;

class Find {

  public static void main (String args[]) {
    Scanner input = new Scanner(System.in); 
    double number;

    do {
        System.out.print("Enter a number: "); 
        number = input.nextDouble();
    } while(!isValid(number));
  }

  private static boolean isValid(double number){
    int minValue = 1;
    int maxValue = 100;

    if (number < minValue || number > maxValue ) {
       System.out.println("Try again");
       return false;
    }
    else {
       return true;
    }
  }
}