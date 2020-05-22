public class ServiceProviderRegistry {
  private Map<Class<?>, ServiceProvider<?>> registry = new HashMap<>();

  public <T extends Service> void register(Class<T> cls, ServiceProvider<T> provider) {
    registry.put(cls, provider);
  }

  @SuppressWarnings("unchecked")
  public <T extends Service> ServiceProvider<T> lookup(Class<T> cls) {
    return (ServiceProvider<T>)registry.get(cls);
  }
}