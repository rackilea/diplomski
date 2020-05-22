@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="myList shouldn't be empty")
public class MyException extends Exception {
  public MyException() { super(); }
  public MyException(String message) { super(message); }
  public MyException(String message, Throwable cause) { super(message, cause); }
  public MyException(Throwable cause) { super(cause); }
}