import java.util.Scanner ;
public class NewSrc {

 public static void main(String[] args) {

    boolean continueCalculation = true;
    Scanner sc = new Scanner(System.in);
    while (continueCalculation == true) {        
        System.out.println("Enter first number.... ");
        double x = sc.nextDouble();
        System.out.println("Enter next number....");
        double y = sc.nextDouble();
        double z = x*y;
        System.out.println("processing answer ....");
        System.out.println("The answer is :- " + z );
        System.out.println("Do you want to continue ?Answer with either Yes or No   ");
        String continueInput = sc.nextLine();
        if (continueInput.equals("No")) //do not use == to compare strings
        {
             continueCalculation = false;
        }
   }

 }

}