public abstract class ServiceBase implements Service {

    public abstract ServiceBase createService();

    @Override
    public void process() {
         createService().process();
    }

}