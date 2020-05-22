public class Activator extends DependencyActivatorBase{
  @Override
  public void destroy(BundleContext arg0, DependencyManager arg1) throws Exception {
  }

  @Override
  public void init(BundleContext arg0, DependencyManager dm) throws Exception {

    Properties props = new Properties();
    props.put(Constants.SERVICE_RANKING, 100);

    dm.add(createComponent().setInterface(Application.class.getName(), props).setImplementation(MyApplication.class));
  }
}