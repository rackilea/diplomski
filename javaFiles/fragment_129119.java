@JmxResource(description = "Lookup cache", domainName = "j256")
public class LookupCache {

    @JmxAttributeField(description = "Number of hits in the cache")
    private int hitCount;
    ...