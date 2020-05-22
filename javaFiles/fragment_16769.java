import java.util.Scanner;

public class Test
{
  public static void main(String[] args) throws InterruptedException
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("How much time (In Minutes) ?");
    int timet= scan.nextInt() * 60; // Convert to seconds
    long delay = timet * 1000;

    do
    {
      int minutes = timet / 60;
      int seconds = timet % 60;
      System.out.println(minutes +" minute(s), " + seconds + " second(s)");
      Thread.sleep(1000);
      timet = timet - 1;
      delay = delay - 1000;

    }
    while (delay != 0);
    System.out.println("Time's Up!");
  }
}