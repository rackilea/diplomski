01 public class A{
02   void test(){};
03   public class B{
04     void test(){
05       test();  // local B.test() method, so recursion, use A.this.test();
06     }
07   }
08 }