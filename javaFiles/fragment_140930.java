import java.lang.Math;
import java.util.Scanner;
import java.math.BigInteger;
public class Main
{
  public static void main(String[] args)
  {
        BigInteger a=BigInteger.valueOf(2894135);
        BigInteger b=BigInteger.valueOf(3787313);
        BigInteger m=BigInteger.valueOf(4028033);
        BigInteger result=a.modPow(b,m); //calculates a^b %m
        System.out.println(result);
  }
}