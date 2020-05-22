public class MyTestListener extends RunListener {
    public void testFailure(Failure failure) {
         //this just prints the message instead of the whole stack
         //printing to STDOUT but you can print to file or whatever
         System.out.println(failure.getMessage());
    }
 }