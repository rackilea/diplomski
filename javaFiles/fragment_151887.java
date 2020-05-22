public class ServiceVerticle extends AbstractVerticle implements UndeployableVerticle  {

   private MyService myService = new MyService(this);

   ...
}