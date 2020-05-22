import java.util.Arrays;
import java.util.Scanner;

public class MinDifference
{

  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    int[] inputs = new int[6];
    for (int i = 0; i < 6; i++)
    {
      System.out.print("Enter an integer: ");

      inputs[i] = scanner.nextInt();
    }
    scanner.close();
    Arrays.sort(inputs);
    int minDiff = inputs[1] - inputs[0];
    for (int j = 2; j != inputs.length; j++)
    {
      minDiff = Math.min(minDiff, inputs[j] - inputs[j - 1]);
    }
    System.out.printf("The minimum difference is %d", minDiff);
  }
}