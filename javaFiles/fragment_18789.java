public interface Callback<T> {
  T execute(Object key, Object value);
}

Callback<Boolean> cb = new Callback<Boolean> {
  @Override
  public Boolean execute(Object k, Object v) { ... }
  // not an @Override
  public Boolean execute(String k, String v) { ... }
}