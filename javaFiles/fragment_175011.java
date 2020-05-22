import java.util.Scanner;

public class U4A4 implements Runnable
{
    private int count = 0;
    private double accum = 0;
    private int apr, min, months;
    private double balance, profit;

    public static void main(String[] args)
    {
        U4A4 u = new U4A4();
        u.run();
    }

    public U4A4()
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter credit card balance: ");
        balance = in.nextDouble();
        System.out.print("\n\nEnter minimum payment (as % of balance): ");
        min = in.nextInt();
        System.out.print("\n\nEnter annual percentage rate: ");
        apr = in.nextInt();

        profit = this.getMonths(balance);

        System.out.println("\n\n\n# of months to pay off debt =  " + count);
        System.out.println("\nProfit for credit card company = " + profit + "\n");
    }

    public double getMonths(double bal)
    {
        double newBal, payment;
        count++;

        payment = bal * min;

        if (payment < 20 && bal > 20)
        {
            newBal = bal * (1 + apr / 12 - 20);
            accum += 20;

        } else if (payment < 20 && bal < 20)
        {
            newBal = 0;
            accum += bal;
        } else
        {
            newBal = bal * (1 + apr / 12) - payment;
            accum += payment;
        }
        if (newBal != 0) {
            getMonths(newBal);
        }

        return accum;
    }

    public void run() {
        // TODO Auto-generated method stub
        // You have to override the run method and implement main login of your thread here.
    }
}