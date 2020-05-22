public interface MyInterface<T> {
  public T getValue();
}

public class Animal implements MyInterface<Integer> {
  @Override
  public Integer getValue() {
    return 5;
  }
}