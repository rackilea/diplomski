ConcurrentHashMap<object, object> table;

public object getFromCache(object key)
{
    value = table.get(key);

    if (value == null)
    {
        //key isn't a key into this table, ie. it's not in the cache
        value = calculateValueForKey(key)
        object fromCache = table.putIfAbsent(key, value);
    }

    return value;
}

/**
* This calculates a new value to put into the cache
*/
public abstract object calculateValueForKey(object key);