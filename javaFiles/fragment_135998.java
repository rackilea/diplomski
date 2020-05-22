import java.util.Scanner;

public class calculations{
    public static void main(String [] args) {
        Scanner reader = new Scanner(System.in);
        Scanner in = new Scanner(System.in);


        double Regpay;
        double Payperhour;
        int HoursAweek;
        double Pay;
        double OvertimeHours;
        double OvertimePay;
        double Dependants;
        double SocSecTax;
        double FederalTax;
        double StateTax;
        int UnionDues;
        double AllTaxes;
        double FinalPay;
        String playAgain;
        int runAgain = 1;

        while (runAgain == 1) {


            System.out.print("Enter your pay per hour:");
            Payperhour = reader.nextDouble();

            System.out.print("Enter your regular Hours a week:");
            HoursAweek = reader.nextInt();

            System.out.print("Enter your overtime hours:");
            OvertimeHours = reader.nextDouble();

            Regpay = Payperhour * HoursAweek;

            OvertimePay = OvertimeHours * 1.5 * Payperhour;

            Pay = OvertimePay + Regpay;

            SocSecTax = Pay * .06;

            FederalTax = Pay * .14;

            StateTax = Pay * .05;

            UnionDues = 10;

            AllTaxes = SocSecTax + FederalTax + StateTax + UnionDues;

            FinalPay = Pay -= AllTaxes;

            System.out.println("Your pay this week will be " + FinalPay);
            {


                System.out.println("How many Dependants:");
                Dependants = reader.nextInt();

                if (Dependants >= 3) {
                    Dependants = Pay + 35;
                    System.out.println("Your Pay is:" + Dependants);
                } else if (Dependants < 3) {

                    System.out.println("Your Pay is:" + Pay);
                }

            }

            System.out.println("Again???  Press 1 to run again and 0 to exit");
            runAgain = reader.nextInt();

        }
    }

}