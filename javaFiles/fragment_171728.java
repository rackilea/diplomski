public class X implements Serializable
{
  public void abcdef()
  {
    // common functionality, merged from A and B
  }
}

public class A extends X implements Serializable
{
  public function abc() { abcdef(); }
}

public class B extends X implements Serializable
{
  public function edf() { abcdef(); }
}