import java.math.*;

class Main {
    public static void main (String args [])
    {
        String hexValue = "00000156A56BE980";
        BigInteger result = new BigInteger(hexValue, 16);
        System.out.println(result);
    }
}