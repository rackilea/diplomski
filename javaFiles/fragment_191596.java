package test;

public class Fraction {

    private int num1;
    private int num2;
    private int denom1;
    private int denom2;

    private int num;
    private int denom;

    public Fraction(int num1, int num2, int denom1, int denom2) {
        this.num1 = num1;
        this.num2 = num2;
        this.denom1 = denom1;
        this.denom2 = denom2;
    }

    public void sum() { //sum the two fractions
        num = (num1 * denom2) + (num2 * denom1);
        denom = denom1 * denom2;
    }

    public void simplify() {

        int gcd = gcd(num, denom);

        num = num / gcd;
        denom = denom / gcd;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Fraction fraction = new Fraction(1,1,4,6); // 1/4 and 1/6
        fraction.sum();
        fraction.simplify();
        System.out.println("Simplified : " + fraction.getNumSimp() + "/" + fraction.getDenomSimp());
    }

    public int getNumSimp() {
        return num;
    }

    public int getDenomSimp() {
        return denom;
    }

}