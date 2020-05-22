public class DispatchTest
{

   private void bar( HashMap<String, Object> map )
   {
   }

   public static void main( String[] args )
   {
      test();
   }

   private static <T> void test()
   {
      DispatchTest dt = new DispatchTest();
      HashMap<String,T> map = new HashMap<>();
      dt.bar( map );
   }
}