class Demo {
   void show() {
      System.out.println("i am in show method of super class");
   }
}
public class Flavor1Demo {

   //  An anonymous class with Demo as base class
   static Demo d2 = new Demo() {
       void show() {
           super.show();
           System.out.println("i am in Flavor1Demo class");
       }
   };
   public static void main(String[] args){
       d2.show();
       try {
        Demo v = d2.getClass().newInstance();
        System.out.println("Object created"+v.getClass().getTypeName()); // Canonical is null
    } catch (InstantiationException | IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
   }
}