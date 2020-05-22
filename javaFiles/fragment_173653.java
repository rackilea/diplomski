package game;

import java.util.Random;

public class Player implements Runnable
{
  private Random random = new Random();
  private int value;
  private int counter;
  private String name;

  public Player(String name, int cycles)
  {
    this.name = name;
    this.counter = cycles;
  }

  public synchronized void run()
  {
    while (true)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

      value = random.nextInt(3);
      System.out.println(name + " ... Value was generated = " + value);
      notify();

      // Otherwise your thread will never stop!
      counter--;
      if (counter <= 0)
      {
        System.out.println(name + " ... Limit of operations is exceeded.");
        break;
      }
    }
  }

  public synchronized Choice getChoice() throws InterruptedException
  {
    System.out.println(name + " ... now can generate value");
    notify();
    System.out.println(name + " ... wait until value is generated");
    wait();
    Choice choice = Choice.values()[value];
    System.out.println(name + " ... returning generated value: " + value);
    return choice;
  }

  public int getCounter()
  {
    return counter;
  }
}