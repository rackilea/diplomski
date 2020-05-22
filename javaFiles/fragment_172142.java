import java.util.Arrays;

public class HelloWorld
{
  public static void main(String[] args)
  {
    String[] strings = new String[] {"bob", "joe", "me"};

    System.out.println(Arrays.toString(strings));

    for (int i = 0; i < strings.length; i++)
    {
      if (strings[i].contains("bob"))
      {
        System.out.println("Found it!");
      }
    }
  }
}