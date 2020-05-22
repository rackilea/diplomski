@JmxResource(domainName = "j256", objectName = "lookupCache")
public class LookupCache {

    // this can also be done as @JmxAttributeMethod on the getter/setters
    @JmxAttributeField(description = "Number of hits in the cache")
    private int hitCount;
    ...

    @JmxOperation(description = "Flush the cache")
    public void flushCache() {
       ...
    }
}