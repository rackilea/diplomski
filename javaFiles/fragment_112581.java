public class Test {
   public static void main(String[] args) {
      System.out.println(contains(Haha.class, "Bad"));
      System.out.println(contains(Haha.class, "Happy"));
      System.out.println(contains(Haha.class, "Sad"));
   }

   static enum Haha {
      Happy, Sad;
   }
}