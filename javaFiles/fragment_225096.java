public class Test {

   public static void main(String[] args) throws Throwable {
    System.out.println(Example.DEFAULT_NAME);
    Example.DEFAULT_NAME = "Jose";
    System.out.println(Example.DEFAULT_NAME);
    try {
        reset();
    } catch (Throwable t) {
        System.out.println("Problems calling reset, maybe not injected?");
    }
    System.out.println(Example.DEFAULT_NAME);
   }

   private static void reset() throws Throwable {
    Method declaredMethod = Example.class.getDeclaredMethod("__NEW_NAME__", new Class[] {});
    declaredMethod.invoke(null, new Object[] {});
   }
}