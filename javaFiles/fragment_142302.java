import java.util.*;
import java.lang.reflect.*;

class Test extends ArrayCallable {
  void myFunc(Double val1, Double val2, Double val3, Double val4) {
    System.out.println("myFunc is running");
  }

  public static void main(String[] args) throws Exception {
    Double[] myArray = {1.0, 2.0, 3.0, 4.0};
    new Test().call("myFunc", myArray);
  }
}

class ArrayCallable {
  void call(String name, Object[] params) throws Exception {
    Class[] types = Arrays.stream(params).map(c -> c.getClass()).toArray(Class[]::new);
    Method m = getClass().getDeclaredMethod(name, types);
    m.invoke(this, params);
  }
}