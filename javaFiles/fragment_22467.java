public class MyThreadSafeClass
{
  public String myMethod(String field1, String field2, String field3)
  {
     return new StringBuilder(field1).append(field2).append(field3).toString();
  }
}