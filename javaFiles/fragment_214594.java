public interface SomeInterface<T> {
  public T logIt(T in);
}

public static void main(String[] args) {
  SomeInterface<Integer> si = (new SomeInterface<Integer>() {
    public Integer logIt(Integer in) {
      System.out.println("in logIt " + in);
      return in;
    }
  });
  System.out.println(si.logIt(100));
}