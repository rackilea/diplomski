package A;
class Example {
   public void test() {}
}

package A;
public class SubExample extends Example {
}

package B;
import A.SubExample;
class OutsidePackage {
  public void some method(SubExample e){
    // Had test been defined with default access in class Example
    // the below line would be a compilation error.
    e.test();
  }
}