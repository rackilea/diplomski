public class LotteryTicket {
   protected int pickAmount;
   protected boolean isRandom;
   protected List<Integer> numbersPicked;
   protected Date datePurchased;
   protected SimpleDateFormat sdf;

   protected int[] numbersToPick;

   //To create random valued ticket
   public LotteryTicket(int pickAmount) {
      this.pickAmount = pickAmount;
      isRandom = true;
   }

   //To create specified valued ticket
   public LotteryTicket(int... numbersToPick) {
      pickAmount = numbersToPick.length;
      isRandom = false;
      this.numbersToPick = numbersToPick;
   }

   public void pickNumbers() {
      numbersPicked = new ArrayList<>(pickAmount);
      if (isRandom) {
         Random random = new Random(System.currentTimeMillis());
         for (int i = 0; i < pickAmount; i++) {
            numbersPicked.add(random.nextInt());
         }
      } else {
         for (int i = 0; i < pickAmount; i++) {
            numbersPicked.add(numbersToPick[i]);
         }
      }
   }

}