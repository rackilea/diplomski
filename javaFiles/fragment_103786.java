import java.net.InetAddress;

/**
 * Singleton class that holds the ExpiringMap used for DNS Cache
 */
public class DnsCache {
    private static ExpiringMap<String, InetAddress> theDnsCache = null;

    public static ExpiringMap<String, InetAddress> getInstance() {
        if (theDnsCache == null) {
            theDnsCache = new ExpiringMap<String, InetAddress>();
        }
        return theDnsCache;
    }
}