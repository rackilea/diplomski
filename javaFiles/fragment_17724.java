public class MyBean implements ConfigurationProvider, DispatcherListener {
  public MyBean() {
    System.out.println("!!! MyBean !!!");
  }

  @Override
  public void dispatcherInitialized(Dispatcher du) {
    System.out.println("!!! dispatcherInitialized !!!");
  }

  @Override
  public void dispatcherDestroyed(Dispatcher du) {
    System.out.println("!!! dispatcherDestroyed !!!");
  }

  @Override
  public void destroy() {
    System.out.println("!!! destroy !!!");
    Dispatcher.removeDispatcherListener(this);
  }

  @Override
  public void init(Configuration configuration) throws ConfigurationException {
    System.out.println("!!! init !!!");
    Dispatcher.addDispatcherListener(this);
  }

  @Override
  public boolean needsReload() {
    return false;
  }

  @Override
  public void loadPackages() throws ConfigurationException {

  }

  @Override
  public void register(ContainerBuilder builder, LocatableProperties props) throws ConfigurationException {

  }
}