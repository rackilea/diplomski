class Owner {

   InnerBar b = new InnerBar();

   void dostuff(){...}

   void doStuffToInnerBar(){
       b.doInnerBarStuf();
   }

   // InnerBar is like a member in Owner.
   class InnerBar { // not containing a method dostuff.
      InnerBar() { 
      // The creating owner object is very much like a 
      // an owner, or a wrapper around this object.
      }
      void doInnerBarStuff(){
         dostuff(); // method in Owner
      }
   }
}