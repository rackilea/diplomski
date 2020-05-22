public class MyServiceFactory implements ServiceFactory<MyServiceImpl> {

    public MyServiceImpl getService(Bundle bundle, ServiceRegistration reg) {
         // create an instance of the service, customised for the consumer bundle
         return new MyServiceImpl(bundle);
    }

    public void ungetService(Bundle bundle, ServiceRegistration reg, MyServiceImpl svc) {
         // release the resources used by the service impl
         svc.releaseResources();
    }
}