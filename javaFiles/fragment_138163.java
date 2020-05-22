public class SomeNodeB extends SimpleNode implements Nameable, Accessible {

   private NameDelegate nameDelegate;
   private AccessDelegate accessDelegate;

   public SomeNodeB(NameDelegate nameDelegate, AccessDelegate accessDelegate) {
      this.nameDelegate = nameDelegate;
      this.accessDelegate = accessDelegate;
   }

   @Override
   public String getName() {
       return nameDelegate.getName();
   }

   @Override
   public String setName(String name) {
       nameDelegate.setName(name);
   }

   @Override
   public boolean getAccessibility() {
       return accessDelegate.getAccessibility();
   } 

    /* etc... */
}