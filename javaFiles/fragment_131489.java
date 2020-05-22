public interface ITest<T> {
  public T test2();
  public T test3();
}

public interface ITestA<T> {
  public T test1(String a, String b);
}

public interface ITestB<T> {
  public T test1();
}

public interface ITestB<T> {
  public T test1(boolean b);
}