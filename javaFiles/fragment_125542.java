@Command(scope = "onos", name = "service-add", description = "Adds a Client")
public class AddCommand implements Action
{
   private MyService serviceBn;

   public AddCommand(MyService myService) {
      this.serviceBn = myService;
   }
   ...
}