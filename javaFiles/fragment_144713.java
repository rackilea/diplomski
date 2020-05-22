public class Main {

   public static void main(final String[] args) {

      final Test test1 = new Test();
      final Test<? extends String> test2 = new Test<? extends String>();

      test1.put(new Integer(1));
      test2.put(new Integer(1));
   }

   private static class Test<T extends String> {

      public void put(final T value) { }

   }
}