@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CacheableTest.CacheConfigurations.class)
public class CacheableTest {

    public static class Customer {

        final private String id;
        final private String name;

        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }

    final public static AtomicInteger cacheableCalled = new AtomicInteger(0);
    final public static AtomicInteger cachePutCalled = new AtomicInteger(0);

    public static class CustomerCachedService {


        @Cacheable("CustomerCache")
        public Customer cacheable(String v) {
            cacheableCalled.incrementAndGet();
            return new Customer(v, "Cacheable " + v);
        }

        @CachePut("CustomerCache")
        public Customer cachePut(String b) {
            cachePutCalled.incrementAndGet();
            return new Customer(b, "Cache put " + b);
        }

    }

    @Configuration
    @EnableCaching()
    public static class CacheConfigurations {

        @Bean
        public CustomerCachedService customerCachedService() {
            return new CustomerCachedService();
        }

        @Bean
        public CacheManager cacheManager() {
            return new GuavaCacheManager("CustomerCache");
        }

    }

    @Autowired
    public CustomerCachedService cachedService;

    @Test
    public void testCacheable() {
        for(int i = 0; i < 1000; i++) {
            cachedService.cacheable("A");
        }
        Assert.assertEquals(cacheableCalled.get(), 1);
    }

    @Test
    public void testCachePut() {
        for(int i = 0; i < 1000; i++) {
            cachedService.cachePut("B");
        }
        Assert.assertEquals(cachePutCalled.get(), 1000);
    }

}