public interface A {
  public String x();
}
public interface B {
}

public class ImplementsBoth implements A, B {

  @Override
  public String x() {...}

}
public class ImplementsA implements A {

  @Override
  public String x() {...}

}
public class ImplementsB implements B {

}