@Component
public class Foo implements Bar {

   @Activate
   void activate(ComponentContext ctx) {
      System.out.println("Activating bundle: " + ctx.getUsingBundle());
   }

   @Deactivate
   void deactivate(ComponentContext ctx) {
      System.out.println("Deactivating bundle: " + ctx.getUsingBundle());
   }
}