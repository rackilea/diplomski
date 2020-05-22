public class Random1
  {
   public static int generate()
   {
    java.util.Random r = new java.util.Random(1);
    int num = r.nextInt(Integer.MAX_VALUE);
    return num;
  }
 }