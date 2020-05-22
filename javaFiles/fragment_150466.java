public class Main
{
   public static void main(String[] args)
   {
       ActList        a = new ActList(...);
       SocketManager sm = new SocketManager(...);

       a.sendMessageWithSocket(sm); //here you pass Main's reference to SocketManager 
   }                                //object to the ActLis class for use
}