public class SomeNodeA extends SimpleNode implements Nameable {

   private NameDelegate nameDelegate;

   public SomeNodeA(NameDelegate nameDelegate) {
      this.nameDelegate = nameDelegate;
   }

   @Override
   public String getName() {
       return nameDelegate.getName();
   }

   @Override
   public String setName(String name) {
       nameDelegate.setName(name);
   }
}