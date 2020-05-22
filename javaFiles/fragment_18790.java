Callback<Boolean> cb = new Callback<Boolean> {
  @Override
  public <K,V> Boolean execute(Operation<K,V> o) { ... }
  // not an @Override
  public Boolean execute(StringOperation o) { ... }
}