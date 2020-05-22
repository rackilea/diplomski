import java.math.BigInteger;

public class Test {
    public static void main(String[] args) throws Exception {
        BigInteger big = BigInteger.valueOf(2)
            .pow(7830457)
            .add(BigInteger.ONE);
        System.out.println(big);
    }
}