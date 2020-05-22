public class TestHandGameChoices {
   public static void main(String[] args) {
      for (HandGameChoice choice1 : HandGameChoice.values()) {
         for (HandGameChoice choice2 : HandGameChoice.values()) {
            int value = HandGameChoice.compare(choice1, choice2);
            String result = "";
            if (value > 0) {
               result = "win";
            } else if (value < 0) {
               result = "lose";
            } else {
               result = "tie";
            }
            System.out.printf("%-8s vs %-8s: %s%n", choice1, choice2, result);
         }
      }
   }
}