int sumOne = 1;
    int sumTwo = 1;
    int sumOneTotal = 0;
    int sumTwoTotal = 0;
    while (sumOne > 0 && sumTwo > 0) {
        System.out.print("Enter a number to add to first sum: ");
        // The user enters in a value for the first sum.
        sumOne = input.nextInt();

        /**
         * We use an if-else statment to ensure sumOne is never less than or
         * equal to 0. If it does it ends the program immediately and totals
         * the sums. This is because we only want the user to enter in
         * positive numbers.
         */
        if (sumOne > 0) {
            sumOneTotal = sumOneTotal + sumOne;
            System.out.print("Enter a number to add to second sum: ");
            // The user enters in a value for the second sum.
            sumTwo = input.nextInt();

            /**
             * We use an if-else statment to ensure sumTwo is never less
             * than or equal to 0. If it does it ends the program
             * immediately and totals the sums. This is because we only want
             * the user to enter in positive numbers.
             */
            if (sumTwo > 0) {
                sumTwoTotal = sumTwoTotal + sumTwo;
            }
        }
    }