double currentBalance = startingBalance;

    for (int i = 0; i < numberOfQuarters; ++i) {
        interestEarned = (currentBalance * (interestRate / 100) * (0.25));
        endingBalance = currentBalance + interestEarned;

        System.out.printf((i + 1) + "%20.2f %14.2f %15.2f \n", currentBalance, interestEarned, endingBalance);

        currentBalance = endingBalance;
    }