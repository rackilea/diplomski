public class MyPublicClass {

   private MyNewInterface executor;

   // probably good idea to make executor final and set it in the constructor

   public void method1(Data1 x) {
           executor.method( ... );
   }

   public void method2(Data2 x) {
           executor.method( ... );
   }
}