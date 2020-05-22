final class Factory
{

  private Map<Class<?>, Class<?>> map = new HashMap<Class<?>, Class<?>>();

  <T> void map(Class<T> type, Class<? extends T> impl)
  {
    map.put(type, impl.asSubclass(type));
  }

  private <T> Class<? extends T> get(Class<T> type)
  {
    Class<?> impl = map.get(type);
    if (impl == null) 
      throw new IllegalArgumentException("Unknown type: " + type);
    return impl.asSubclass(type);
  }

  <T> T create(Class<T> type) 
    throws Exception
  {
    Class<? extends T> impl = get(type);
    Constructor<? extends T> ctor = impl.getConstructor();
    return ctor.newInstance();
  }

}