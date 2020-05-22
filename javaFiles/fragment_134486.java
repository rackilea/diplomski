public class FooCorporation {
    static final double minimumWage = 8.0; // static means that can be accessed without creating an object of the class and instantiating it
    static final int maxHours = 60; // final means constant = cannot be changed after declared
    static double basePay=0; // initialize them to zero, at least you know your program won't throw null pointer exception if forgot to set their 
                             //values before invoking the method
    static int hoursWorked=0;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i=1; i<=3; i++, System.out.println()){
           System.out.println("For Employee Number: " + i);
           System.out.println("Enter Base Pay:");
           basePay = in.nextDouble();
           System.out.println("Enter Hours Worked:");
           hoursWorked = in.nextInt();
           salaryCalculation(); 
       }
   }
     public static void salaryCalculation(){
        double totalSalary = 0;
        if ((basePay < minimumWage) || (hoursWorked > maxHours)){
            System.out.println("Error!");
        }
        else {   

        if (hoursWorked > 40){
                    totalSalary = basePay * 40 + 1.5*basePay*(hoursWorked - 40);
                }
                else {
                    totalSalary = basePay * hoursWorked;
                }
                System.out.println("Your total salary is " + totalSalary);
            }
        }

    }