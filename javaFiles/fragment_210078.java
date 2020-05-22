public class MyService extends ServiceBase {

    @Override
    public ServiceBase createService() {    
        return new AnotherService();
    }

}