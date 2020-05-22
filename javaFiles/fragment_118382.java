import java.util.*;
import java.lang.reflect.*;

class B { 
  B() { System.out.println("B"); }
  void foo() { System.out.println("B.foo"); }
}

public class Test{
  B b;
  void bar() {
    b = new B() {
          class C { C() { System.out.println("inner C"); } }
          void foo() { System.out.println("inner foo"); }
    };
    b.foo();
}
public static void main(String[] args) throws Exception {
    Test test = new Test();
    test.bar();

    Class<?> enclosingClass = Class.forName("Test$1");
    Class<?> innerClass = Class.forName("Test$1$C");

    Constructor<?> ctor = innerClass.getDeclaredConstructor(enclosingClass);
    Object innerInstance = ctor.newInstance(test.b);
  }
}