public class Test extends Super{
   public static void main (String[] args){
      Test t = new Test();
      t.print();
   }
   void print1(){
      System.out.println("Hello");
   }
}
class Super{
   private void print1(){
      System.out.println("hi");
   }
   void print(){
      print1();
      this.print1();
   }
}