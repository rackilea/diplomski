public class Foo {

   static {
     //this will be run when the class is loaded
     try { Class.forName("fully.qualified.class.name.that.i.want.to.Load"); }
     catch ...
   }

   public static void main (string args[])
   {
    //run my server...
   }
}