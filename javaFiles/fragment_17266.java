public class Temp{
   public static void main(String[] args){
      foo("a", "b", "c");
      foo(null, null);
      foo((Object)null);
      Object bar = null;
      foo(bar);
   }

   private static void foo(Object...args) {
      System.out.println("foo called, args: " + asList(args));
   }
}