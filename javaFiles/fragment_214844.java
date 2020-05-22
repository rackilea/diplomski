public class Head {

   String object;

   public void pickUp(String object)
   {   
       this.object = object;
       System.out.println("Picked up "+object);
   }

}

public class SomeOtherClass {

   Head head = new Head();

   public void pickup()
   {
       head.pickUp(head.object);

   } 
}