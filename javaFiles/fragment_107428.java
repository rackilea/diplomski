public <T extends HasUniqueIdentifier & Combinable<T>> 
List<T> combine(List<T> items) 
{
    ...
    List<T> output = new ArrayList<T>();
    ...

    for (T item : output) {
        if (item instanceof Sublistable<?>) 
            combineSublist((Sublistable<?>)item);

    return output;
}

private <V> void combineSublist(Sublistable<V> sublistableItem)
{
    if (sublistableItem.hasSublist()) {
        sublistableItem.setSublist(combine(sublistableItem.getSublist));
}