public class Cell<T> { 
  private T value;

  public void set(T t) { value = t; }
  public T get() { return value; }
}


Cell<Integer> ci = new Cell<Integer>();
Cell<? extends Number> cn = ci;

cn.set(new Double(5.0));  // (A) <-- Compile error here


Integer n = ci.get(); // (B) Runtime error!