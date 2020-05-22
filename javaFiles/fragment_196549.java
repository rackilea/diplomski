Scanner keyboard = new Scanner(System.in);

    double [] currency = new double[] {0.05,0.10,0.20,0.50,1.00,2.00,5.00,10.00,20.00,50.00,100.00};
    String [] currencytext = {"$0.05","$0.10","$0.20","$0.50","$1.00","$2.00","$5.00","$10.00","$20.00","$50.00","$100.00"};

    String payment = keyboard.next();

    double sum = 100; // <- Working example - Read sum from keyboard entry

    while (sum > 0) {

        boolean paymentFound = false;

        for (int i = 0; i < currencytext.length; i++) {

            if (payment.equals(currencytext[i])) {

                sum = sum - currency[i];
                paymentFound = true;

                if (sum == 0) {
                    System.out.println("You gave " + payment);
                    System.out.println("Perfect! No change given.");

                    // System.out.print("Thank you" + name + ".");

                    System.out.println("See you next time.");
                    break;
                } else if (sum < 0) {
                    System.out.println("You gave " + payment);
                    System.out.println("Your change:" + (-1 * sum));
                    break;
                }
            }
        }

        if (!paymentFound) {
           System.out.println("Invalid coin or note. Try again. \n");

        }

        if (sum > 0) {
            System.out.format("$%.2f remains to be paid. Enter coin or note: ", sum);
            payment = keyboard.next();
        }
    }