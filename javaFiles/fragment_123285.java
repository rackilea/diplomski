public class Subject {

  public Subject() {
    initializeCache();
  }

  private LoadingCache<String, String> cache;

  @VisibleForTesting
  void initializeCache() {
    cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
      @Override
      public String load(String key) throws Exception {
        return retrieveValue(key);
      }
    });
  }

  /* ... */
}

@Test
public void test() {
  subject.initializeCache();
  doReturn(good).when(subject).retrieveValue(anyString());
  assertEquals(good, subject.getValue("a"));
}