public void method_A() {
   for(...) {
      ...
      try {
         anotherService.method_B();
      } catch (Exception e) {
         logger.error(...);
      }
   }
}