import java.math.BigInteger;

public class Test
{
    public static void main(String[] args)
    {
        int bits = 3;

        BigInteger value = BigInteger.ZERO
                                     .setBit(bits)
                                     .subtract(BigInteger.ONE);
        System.out.println(value);  // Prints 7 == 111 in binary
    }
}