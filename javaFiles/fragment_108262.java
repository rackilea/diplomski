/**
 * Called after an item has been inserted (after the transaction completes),
 * instead of calling release().
 * This method is used by "asynchronous" concurrency strategies.
 *
 * @param key The item key
 * @param value The item
 * @param version The item's version value
 * @return Were the contents of the cache actual changed by this operation?
 * @throws CacheException Propogated from underlying {@link org.hibernate.cache.Region}
 */
public boolean afterInsert(Object key, Object value, Object version) throws CacheException;