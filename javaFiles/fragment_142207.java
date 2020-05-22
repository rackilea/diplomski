import java.math.BigInteger;
import java.util.Scanner;
import java.util.ArrayList;

public class Perfect {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Enter the number");

    BigInteger n = input.nextBigInteger();
    BigInteger sum = BigInteger.valueOf(0);
    BigInteger i = BigInteger.valueOf(1);
    ArrayList<BigInteger> factors = new ArrayList<BigInteger>();

    for (; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {

      if (n.mod(i).equals(BigInteger.ZERO)) {

        sum = sum.add(i);
        factors.add(i);
      }
    }
    if (sum.equals(n)) {

      System.out.print(n + "=" + factors.get(0));
      for (int idx = 1; idx < factors.size(); idx++) {
        System.out.print("*" + factors.get(idx));
      }
      System.out.println();
    } else {
      System.out.println("the given number " + n + " is not a perfect number");
    }
  }

}