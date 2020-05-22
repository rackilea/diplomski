public class AnnualCompensation {  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //create salary variable and commission percentage variable 
        double salary = 60000;

        //create command output for the user to get directions to enter value
        System.out.println("Enter total amount of sales for the year: ");
        double value = input.nextDouble();

        System.out.println("Your annual compensation is: " + "$" + AnnualCompensationCalculator.calculateCompensation(value,salary));    
    }  
}