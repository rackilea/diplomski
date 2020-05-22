private int myMethod (int n, int dSum) {
    int counter = 0;
    while (n>0) {
        dSum += n%10;
        n /= 10;
        counter++;
    }
    return counter;

}