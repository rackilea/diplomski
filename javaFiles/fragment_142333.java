public static class SomeClassFactory {
      public interface CanPrint {
        public void print();
      }

      public static CanPrint get() {
        return new SomeClass();
      }

      public static class SomeClass implements CanPrint {
        @Override
        public void print() {
          System.out.println("Runs fine!");
        }
      }
    }