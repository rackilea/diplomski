import org.bridj.*;     // C interop and core classes
import org.bridj.ann.*; // annotations
import org.bridj.cpp.*; // C++ runtime
import static org.bridj.Pointer.*; // pointer factories such as allocateInt(), pointerTo(java.nio.Buffer), etc...

@Library("test")
public class TestLibrary {
   static {
      BridJ.register(); // binds all native methods in this class and its subclasses
   }
   public static class MyClass extends CPPObject {
      @Virtual(0) // says virtualMethod is the first virtual method
      public native void virtualMethod(int i);
      public native void normalMethod(int i);
   };
   public static native void getSomeCount(Pointer<Integer> countOut);

   public static void test() {
      Pointer<Integer> pCount = allocateInt();
      getSomeCount(pCount);
      MyClass t = new MyClass();
      t.virtualMethod(pCount.get(), 0.5f);
  }
}