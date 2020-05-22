public class Math {

   boolean notNumber = false; // instance
   static boolean notString = false; // static

    public static void main(String[] args) {

        ...    
        notNumber = true; //doesn't work as refers an instance field
        notString = true; // work as refers a static field
    }
  ...
 }