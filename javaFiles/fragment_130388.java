@Singleton
public class CacheBean {
    Cache cache;
    // Setup an automatic timer to refresh
    // the Singleton instance cache every 10 minutes
    @Schedule(minute=”*/10”, hour=”*”, persistent=false)
    public void refresh() {
    // ...
    }
}