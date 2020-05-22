import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    analyze(new int[]{0,42,3,7,8});
    analyze(new int[]{4,3,10});
  }

  private static void analyze(int[] n) {
    int sum = 0;
    for (int i = 0; i < n.length; i++) {
      System.out.println("The (integer) value for n" + (i+1) + " is " + n[i]);
      sum += n[i];
    }

    System.out.println("The sum is : " + sum);

    Arrays.sort(n);
    int maxRange = n[n.length - 1] - n[0];

    double aMean = (double)sum / n.length;

    System.out.println("the arithmetic mean is : " + aMean);
    System.out.println("The maxRange is : " + maxRange);
  }
}