public class Pick4 extends LotteryTicket {

   //For random valued ticket  
   public Pick4() {
      super(4);
   }
   //For specified valued ticket    
   public Pick4(int pick1, int pick2, int pick3, int pick4) {
      super(pick1, pick2, pick3, pick4);
   }

}