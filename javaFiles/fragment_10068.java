public class Bar {
   public final void foo() {
   }
}

public class Error extends Bar {
   // Error in java, can't override
   public void foo() {
   }
}