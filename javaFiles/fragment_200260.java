public static void execute(ThrowingRunnable action,
                           ThrowingRunnable onCatch,
                           ThrowingRunnable onFinally) throws Exception {
   try(AutoCloseable ao = onFinally) {
       action.run();
   } catch(Exception e) {
       onCatch.run();
       throw e;
   }
}