public class CommonsMathTest {

    public static void main(String[] args) {

        BigFraction one = new BigFraction(1524, 1000);
        System.out.println("one   = " + one);

        BigFraction two = new BigFraction(251, 100);
        System.out.println("two   = " + two);

        BigFraction three = one.divide(two);
        System.out.println("three = " + three);

        BigFraction four = new BigFraction(1524, 1000);
        System.out.println("four  = " + four);

        BigFraction five = new BigFraction(5, 2);
        System.out.println("five  = " + five);

        BigFraction six = four.divide(five);
        System.out.println("six   = " + six + " = " + six.bigDecimalValue());
    }
}