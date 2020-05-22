public Map<Object, Object> merge ( Map<?, ?> map1, Map<?, ?> map2 )
{
    Map<Object, Object> merged = new HashMap<Object, Object>();
    if ( map1 == null || map2 == null )
    {
        if ( map1 != null )
        {
            merged.putAll( map1 );
        }
        if ( map2 != null )
        {
            merged.putAll( map2 );
        }
        return merged;
    }

    Set<Object> allKeys = new HashSet<Object>();
    allKeys.addAll( map1.keySet() );
    allKeys.addAll( map2.keySet() );

    for ( Object key : allKeys )
    {
        Object v1 = map1.get( key );
        Object v2 = map2.get( key );
        if ( v1 instanceof Set || v2 instanceof Set )
        {
            Set<Object> newSet = new HashSet<Object>();
            if ( v1 instanceof Set )
            {
                newSet.addAll( (Set) v1 );
            }
            if ( v2 instanceof Set )
            {
                newSet.addAll( (Set) v2 );
            }
            merged.put( key, newSet );
        }
        else if ( v1 instanceof Map || v2 instanceof Map )
        {
            Map<?, ?> m1 = v1 instanceof Map ? (Map<?, ?>) v1 : null;
            Map<?, ?> m2 = v2 instanceof Map ? (Map<?, ?>) v2 : null;
            merged.put( key, merge( m1, m2 ) );
        }

    }
    return merged;
}