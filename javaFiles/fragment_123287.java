public class Subject {

  private CacheLoader<String, String> cacheLoader = new CacheLoader<String, String>() {
    @Override
    public String load(String key) throws Exception {
      return valueRetriever.apply(key);
    }
  };

  private LoadingCache<String, String> cache =
      CacheBuilder.newBuilder().build(cacheLoader);

  Function<String, String> valueRetriever = new Function<String, String>() {
    @Override
    public String apply(String t) {
      System.out.println("I should not be called!");
      return "bad";
    }
  };

  public String getValue(String key) {
    return cache.getUnchecked(key);
  }
}

@Test
public void test() {
  subject = new Subject();
  subject.valueRetriever = (x -> good);
  assertEquals(good, subject.getValue("a"));
}