public class TcpErrorHandler {

   public void onException(TcpConnectionExceptionEvent event) {
       System.out.println("Exception!!! ");
       event.getCause();
       ....
   } 

}