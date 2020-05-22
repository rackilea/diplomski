package cruft;

/**
 * Staff
 * @author Michael
 * @link https://stackoverflow.com/questions/27465427/how-to-compute-hours-rate-pay-when-i-compile-i-am-getting-error-with-operatio
 * @since 12/13/2014 8:27 PM
 */

import java.io.Console;

public class Staff {
    private int hours;
    private int rate;
    private double pay;

    public Staff() {
        hours = 0;
        rate = 0;
        pay = 0;
    }

    public void getEmployee() {
        Console console = System.console();
        System.out.println(" Please Enter hours");
        hours = Integer.parseInt(console.readLine());
        System.out.println(" Please Enter rate");
        rate = Integer.parseInt(console.readLine());
    }

    public void showEmployee() {
        Console console = System.console();
        System.out.println(" Pays = " + pay);
    }

    public void computePay() {
        if (hours > 40) {
            pay = (40 * rate) + ((hours - 40) * (1.5 * rate));
        } else {
            pay = (hours * rate);
        }
    }
}