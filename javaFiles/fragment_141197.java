public MyConsole
{
  private static TextField field;
  public static void setField(TextField givenField)
  {
    field = givenField;
  }

  public static void print(String msg)
  {
    field.append(msg);
  }
}