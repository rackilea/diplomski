/**
 * 
 * @return true if Caching system is live otherwise false
 */
public boolean isAlive()
{
    return net.sf.ehcache.Status.STATUS_ALIVE == cacheManager.getStatus();
}