import java.util.Arrays;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] n = new int[3];
    int sum = 0;

    for (int i = 0; i < n.length; i++) {
      System.out.println("Enter an integer value for n" + (i+1));
      n[i] = in.nextInt();
      System.out.println("The (integer) value for n" + (i+1) + " is " + n[i]);
      sum += n[i];
    }

    System.out.println("The sum of n1+n2+n3 = " + sum);

    Arrays.sort(n);
    int maxRange = n[n.length - 1] - n[0];

    double aMean = (double)sum / n.length;

    System.out.println("the arithmetic mean is : " + aMean);
    System.out.println("The maxRange is :" + maxRange);
    in.close();
  }
}