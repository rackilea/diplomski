public class Test
{
  public static String hideParamValue(String input, final String... params)
  {
    for (String param : params)
    {
      input = input.replaceAll(
        "(" + param + "=)\"(?:[^\"\\\\]|\\\\.)*\"",
        "$1***");
    }
    return input;
  }

  public static void main(String[] args)
  {
    String s = "PARAM1=\"a b c\", PARAM2=\"d \\\"e\\\" f\", PARAM3=\"g h i\"";
    System.out.println(s);
    System.out.println(hideParamValue(s, "PARAM2", "PARAM3"));
  }
}