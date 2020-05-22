public interface ErrorHandlingCloseable extends AutoCloseable {
     void run() throws Exception;
     void onError(Exception e);

     static void execute(ErrorHandlingClosable ehc) throws Exception {
         try(ErrorHandlingClosable temp = ehc) {
             ehc.run();
         } catch(Exception e) {
             ehc.onError(e);
             throw e;
         }
     }
}