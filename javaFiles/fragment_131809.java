public class Fraction {
    //marking the fields as final in order to only be initialized
    //in class constructor
    private final int numerator;
    private final int denominator;

    public Fraction() {
        //always initialize the fields in constructor
        numerator = 0;
        denominator = 1; //because it cannot be zero
    }

    /**
     * Constructor with two int parameters
     * @param num is numerator
     * @param den is denominator
     */
    public Fraction(int num, int den) {
        if (den==0) {
            //denominator cannot be zero
            //it is better to throw an exception than just returning
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        int[] fractionData = this.normalize(num, den);
        //always initialize the fields in constructor
        this.numerator = fractionData[0];
        this.denominator = fractionData[1];
    }

    private int[] normalize(int numParam, int denParam) {
        int[] fractionData = new int[2];
        fractionData[0] = numParam;
        fractionData[1] = denParam;
        BigInteger gcd;
        BigInteger num = BigInteger.valueOf(numParam);
        BigInteger den = BigInteger.valueOf(denParam);
        gcd = num.gcd(den);
        if (gcd.intValue() > 1) {
            fractionData[0] = numParam / gcd.intValue();
            fractionData[1] = denParam / gcd.intValue();
        }
        return fractionData;
    }

    //leaving the rest of the implementation up to you...
}