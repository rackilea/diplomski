public static double getTFee(int accountNumber) {
    if (transactionCount[accountNumber] >= 4) {
        return transactionCount[accountNumber] - 3;
    } else {
        return 0;
    }