public class MyClass {
    private boolean methodUsed = false;
    public void runOnceMethod() {
      if (this.methodUsed) {
        return;
      }
      // ...
      // Method logic
      // ...
      this.methodUsed = true;
    }     
  }