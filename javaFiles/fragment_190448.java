import java.util.Arrays;

public class Numbers
{
  public static void main(String[] args)
  {
    int a=3;
    int b=2;
    int c=1;
    int[] numbers = {a,b,c};
    Arrays.sort(numbers);
    System.out.println("The highest number is "+numbers[2]);
    System.out.println("The middle number is "+numbers[1]);
    System.out.println("The lowest number is "+numbers[0]);
  }
}