public abstract class ServiceBase<T extends Service> implements Service {

    public abstract T createService();

    @Override
    public void process() {
         createService().process();
    }

}