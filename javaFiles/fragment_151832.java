public class LoanTable {

     public static void main(String[] args) {
        //Declaring Variables
        double k;
        double n;
        double c;
        double p;
        double a;
        double low;
        double high;

        int time;

        System.out.println("Amount of the loan: ");
        p = 100000;
        System.out.println("Principal = $" + p);

        System.out.println("The length of loan in years: ");
        time =30 ;
        System.out.println("Time = " + time + " years");

        System.out.println("A low interest rate in %: ");
        low = 0.11;
        System.out.println("Low rate = " + low + "%");

        System.out.println("A high interest rate in %: ");
        high = 0.12;
        System.out.println("High rate = " + high + "%");

        System.out.println("---------------- Not working well  ------------------");
        //While Loop
        while (low <= high) {
            /*
             * changed calculation of k
             */
            k = low /12;
            n = time * 12;
            c = Math.pow((1 + k), n);
            a = (p * k * c) / (c - 1);

            System.out.println("Annual interest rate: " + (low * 100));
            System.out.println("Monthly Payment: " +a /* Format.left(a, 2, 2)*/);

            low += (0.25 / 100);

            /*
             * at the 4th loop low = 0.12000000000000001
             * so low > high and while block is terminated.
             */
             System.out.println("low = "+ low);

         }

        System.out.println("---------------- Alternative 1  ------------------");
        //While Loop
        low = 0.11;
        high = 0.12;
        int counter = 0;
        double interest = low;

        while (  interest <=  high   ) {

            /*
             * changed calculation of k
             */
            k = interest /12;
            n = time * 12;
            c = Math.pow((1 + k), n);
            a = (p * k * c) / (c - 1);

            System.out.println("Annual interest rate: " + (interest * 100));
            System.out.println("Monthly Payment: " +a /* Format.left(a, 2, 2)*/);

            counter++;
            /*
             * recalculate interest from low, to avoid accumulating 
             * rounding error 
             */
            interest = low + ((0.25/100)* counter);
         }

        System.out.println("---------------- Alternative 2  ------------------");
        //While Loop
        low = 0.11;
        high = 0.12;

        /*
         * cast float to reduce the accuracy. A better alternative would be
         * to declare low and high as float
         */
        while (  (float)low <=  (float)high   ) {
            /*
             * changed calculation of k
             */
            k = low /12;
            n = time * 12;
            c = Math.pow((1 + k), n);
            a = (p * k * c) / (c - 1);

            System.out.println("Annual interest rate: " + (low * 100));
            System.out.println("Monthly Payment: " +a /* Format.left(a, 2, 2)*/);

            low += (0.25 / 100);

         }

        System.out.println("---------------- Alternative 3  ------------------");

        //While Loop
        /*
         * work with integer
         */
        int lowInterest  = 1100;
        int highInterest = 1200;

        while (  lowInterest <=  highInterest  ) {
            /*
             * changed calculation of k
             */
            k = (float)lowInterest /(12*10000);
            n = time * 12;
            c = Math.pow((1 + k), n);
            a = (p * k * c) / (c - 1);

            System.out.println("Annual interest rate: " + ((float)lowInterest /100));
            System.out.println("Monthly Payment: " +a /* Format.left(a, 2, 2)*/);

            lowInterest += 25;

         }

      }
    }