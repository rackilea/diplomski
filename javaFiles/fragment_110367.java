import java.math.BigInteger;
import java.util.Random;

public class BigRandom {

    public static void main(String[] args) {
        BigInteger result = getRandomBigInteger();
        System.out.println(result);
    }

    public static BigInteger getRandomBigInteger() {
        Random rand = new Random();
        BigInteger result = new BigInteger(128, rand); // (2^128-1) maximum value

        return result;
    }

}