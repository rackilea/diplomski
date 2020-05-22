public class MainActivity implements SoftResetListener
{
   public void softReset()
   {
      //replace with your looper instance
      looper.getIOIOBoardInstance().softReset();
   }

}