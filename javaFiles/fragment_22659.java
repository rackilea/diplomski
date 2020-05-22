import java.util.*;
import java.text.*;

public class HelloWorld
{
  public static void main(String[] args)
  {
  java.text. SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar c = Calendar.getInstance();
c.setTime(new Date()); // Now use today date.
c.add(Calendar.DATE, -5); //  5 days back date
String output = sdf.format(c.getTime());
System.out.println(output);
  }
}