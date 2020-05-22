public static NumCounter positiveOrNegativeNumber(int n, NumCounter numCounter) {

    if (n>0) {
        numCounter.setPositiveNumCounter(numCounter.getPositiveNumCounter()+1);
    } else if (n<0) {
        numCounter.setNegativeNumCounter(numCounter.getNegativeNumCounter()+1);
    }
    return numCounter;
}