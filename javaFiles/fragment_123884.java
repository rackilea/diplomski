abstract class SuperA {
   // making these private also helps
   // because it limits child classes to ONLY use getters
   // they can't even 'fiddle with' the raw values
   private Resource a;
   private Resource b;

   // would you want this public? perhaps also no 'access-modifier' 
   // the 'exact' specifics of a lot of this class would depend on your
   // specific use case (But I'd think you would want this package-only too most likely)
   public SuperA() {
   }

   // note no 'access-modifier', means package use only.
   SuperA(Resource a, Resource b) {
      this.a = a;
      this.b = b;
   }


   // can also have the same with setters
   // again no 'access-modifier' 
   final setResourceA(Resource a){ this.a = a;}
   final setResourceB(Resource b){ this.b = b;}

   public final Resource getResourceA() {
       return a;
   }


   public final Resource getResourceB() {
       return b;
   }

}