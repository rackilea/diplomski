public class FinalFieldExample {
      public FinalFieldExample() {
         ...
         // very bad idea because the constructor may not have finished
         FinalFieldExample.f = this;
         ...
      }
  }