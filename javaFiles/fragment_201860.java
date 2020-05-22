@Pointcut("execution(@Filter java.util.Collection+ *(..)) "
        + "&& @annotation(filter) ")
public void filterCollection(final Filter filter) {
    /* ... */
}

@Pointcut("execution(@Filter java.util.Map+ *(..)) "
        + "&& @annotation(filter) ")
public void filterMap(final Filter filter) {
    /* ... */
}

@AfterReturning(value="filterCollection(filter)", returning="collection")
public void handlingReturnCollection(final Filter filter, Collection collection) {
    System.out.println(collection);
}

@AfterReturning(value="filterMap(filter)", returning="map")
public void handlingReturnMap(final Filter filter, Map map) {
    System.out.println(map);
}