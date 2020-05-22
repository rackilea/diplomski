class B {
   void m(B a){
          System.out.println(" b");
   }  

   void m(Cde a){
         System.out.println("cde");
   }  
}

public class ABC{
       public static void main(String[] args){
          B ob1= new Cde();
          Cde ob2=new Cde();
          ob1.m(ob2);
       }
}