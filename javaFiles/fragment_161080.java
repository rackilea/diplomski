class Test extends Throwable
{
 String message;
 Test(String msg)
 {
  message = msg;
 }
 public String toString() {
  return "BadException: " + message;
 }
}

class BadException extends Test
{
 BadException(String s)
 {
  super(s);
 }
}