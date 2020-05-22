public class StuffManager {

  private final Map<Class<?>, Consumer<?>> stuff = new HashMap<>();

  public <T> void register(Class<T> key, Consumer<? super T> val) {
    stuff.put(key, val);
  }
}