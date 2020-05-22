import java.math.BigInteger;

/**
 *
 * @author Sedrick
 */
public class Main
{

    public static void main(String[] args)
    {
        String value = "000001234567";
        BigInteger bigInteger = new BigInteger(value);
        System.out.println(bigInteger.longValue());
    }

}