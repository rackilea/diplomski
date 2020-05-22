@Component(service={}, immediate=true )
public class FooManagerImpl implements FooManager {

   private ServiceRegistration<FooManager> registration;

   @Reference
   volatile List<FooService> foos;

   @Activate
   void activate( BundleContext context, Map<String,Object> properties ) {
     registration = context.registerService(FooManager.class, this, new Hashtable<String,Object>(properties));
   }

   @Deactivate
   void deactivate() {
      registration.unregister();
   }

   ...
}