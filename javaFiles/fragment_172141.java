public class HelloWorld
{
  public static void main(String[] args)
  {
    String[] strings = new String[] {"bob", "joe", "me"};

    for (int i = 0; i < strings.length; i++)
    {
      if (strings[i].contains("bob"))//doing "b" will also find "bob"
      {
        System.out.println("Found it!");
      }
    }
  }
}