class Foo {
   class Bar { }
   static class Baz { }
   void run() {
      Helper t = new Helper() {
         int helpMethod() {
            return 2;
         }
      };
    }
}