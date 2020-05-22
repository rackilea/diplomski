import java.text.*;
import java.util.*;

public class Test
{
  public static void main(String args[])
  {
    new Test();
  }

  public Test()
  {
    try
    {
    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
    Date d = df.parse("11-02-2012");

    System.out.println(d);
    }
    catch(Exception e) { }
  }
}