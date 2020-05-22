public class StaticMethods {
   public static void main (String[] args) {     
      int a = 6;
      int b = 9;
      int result = getMultiple(a,b);
      System.out.println(result + "\n");

      System.out.println("The first " + a + " multiples of " + b + " are: ");
      int p[] = getMultiples(a,b);



   }
   public static int getMultiple(int a,int b) {
      return (int) (a * b);
   }
   public static int[] getMultiples(int a, int b) {
      int[] p = new int[a];
      for (int i = 1; i <= a; i++) {
         p[i-1] = getMultiple(a,i);
      }
      return p;
   }   
}