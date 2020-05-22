import java.util.Comparator;

public enum HandGameChoice  {
   ROCK,
   PAPER,
   SCISSORS,
   LIZARD,
   SPOCK;

   private static MyComparator myComparator = new MyComparator();

   public static int compare(HandGameChoice o1, HandGameChoice o2) {
      return myComparator.compare(o1, o2);
   }

   private static class MyComparator implements Comparator<HandGameChoice> {
      private int[][] winMatrix = {
            { 0, -1,  1,  1, -1},
            { 1,  0, -1, -1,  1},
            {-1,  1,  0,  1, -1},
            {-1,  1, -1,  0,  1},
            { 1, -1,  1, -1,  0}
      };

      @Override
      public int compare(HandGameChoice o1, HandGameChoice o2) {
         return winMatrix[o1.ordinal()][o2.ordinal()];
      }
   }
}