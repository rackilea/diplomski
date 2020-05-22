int maxNum = Integer.MIN_VALUE;
    int minNum = Integer.MAX_VALUE;

    for (int checkNum = 0; checkNum < 20; checkNum += 1) {
        maxNum = Math.max(maxNum, inputtedNumber[checkNum]);
        minNum = Math.min(minNum, inputtedNumber[checkNum]);
    }