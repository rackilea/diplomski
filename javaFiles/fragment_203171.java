// other (better?) way, put all keys in neighbor class
public interface DESCMessage {
  public static final String HELLO_KEY = "hello_key";
}

public class Foo {
  ...
  messages.getString(DESCMessage.HELLO_KEY);
}