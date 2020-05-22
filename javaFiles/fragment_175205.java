public interface MyType {
  public String giveHello();

  public static class MyTypeImpls {
     public static String giveHello() { return "Hello!" }
  }
}

public final class Polite implements MyType {
  //does not override
  public String giveHello() { return MyType.MyTypeImpls.giveHello() }
}

public final class Rude implements MyType {
  //does override
  override fun giveHello() { return "I don't like you" }
}