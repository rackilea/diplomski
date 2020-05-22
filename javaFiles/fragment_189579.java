static <U,V,W> W putNestedEntry(
        Map<U,Map<V,W>> nest,
        U nestKey,
        V nestedKey,
        W nestedValue)
{
    Map<V,W> nested = nest.get(nestKey);

    if (nested == null)
    {
        nested = new HashMap<V,W>();
        nest.put(nestKey, nested);
    }

    return nested.put(nestedKey, nestedValue);        
}