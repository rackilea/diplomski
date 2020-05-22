public class Fraction implements Comparable<Fraction> {
   private int x1, x2; // implement get/set

   public int compareTo(Fraction o) {
       double tmp = Math.abs((double)x1 / x2 - (double)o.x1 / o.x2);
       if (tmp < 0) return -1;
       if (tmp < 1e-9) return 0;
       return 1;
   }
}