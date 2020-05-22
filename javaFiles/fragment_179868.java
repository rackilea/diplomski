public class InsectGrowth {
   public static void main (String [] args) {
      int numInsects;
      Scanner scnr = new Scanner(System.in);
      numInsects = scnr.nextInt(); // Must be >= 1

      while (numInsects < 200) {
          System.out.print(numInsects + " ");
         numInsects = numInsects * 2;
      }

      System.out.println();

   }
}