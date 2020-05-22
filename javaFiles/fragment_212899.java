// output:
// [{value1=one, value2=1}, {value1=two, value2=2}, {value1=three, value2=3}]

import java.util.Arrays;

import com.google.gson.Gson;

public class Foo
{
  public static void main(String[] args)
  {
    Gson GsonObject = new Gson();

    String JSInput = "[{\"value1\":\"one\",\"value2\":1},{\"value1\":\"two\",\"value2\":2},{\"value1\":\"three\",\"value2\":3}]";
    TabClass[] Input_String = GsonObject.fromJson(JSInput, TabClass[].class);
    System.out.println(Arrays.toString(Input_String));
  }
}

class TabClass
{
  private String value1;
  private int value2;

  @Override
  public String toString()
  {
    return String.format(
        "{value1=%s, value2=%d}",
        value1, value2);
  }
}