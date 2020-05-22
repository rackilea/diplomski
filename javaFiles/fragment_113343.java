interface MyDataStore<V>{
  V retrieve(UUID id);
  void remove(UUID id);
}

public final class MockDataStore implements MyDataStore<String>{
  private final static MockDataStore instance = new MockDataStore();
  public static MockDataStore instance(){
    return instance;
  }
  private MockDataStore(){}
  private final ConcurrentHashMap<UUID,String> m = 
    new ConcurrentHashMap<UUID,String>();
  @Override
  String retrieve(UUID id){
    return m.get(id);
  }
  @Override
  void remove(UUID id){
    m.remove(id);
  }
}