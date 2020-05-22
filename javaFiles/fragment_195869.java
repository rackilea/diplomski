public static void main(String[] args) {
    int countZeros = 0, countOnes = 0;

    for (int i=0; i<10000; i++) {
        int value = randomNumberGen();
        if (value==0)
            countZeros++;
        else if (value==1)
            countOnes++;
        else
            throw new RuntimeException("Bad number");
    }

    System.out.println("0: "+countZeros);
    System.out.println("1: "+countOnes);
}

public static int randomNumberGen() {
    double r = Math.random();
    double p = 0.6;
    if (r > p)
        return 0;
    else
        return 1;
}