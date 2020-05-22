// Java 7
public long countCachedEntitiesL1(Class clazz) {
    long count = 0;
    for (Map.Entry<Object, Object> entity : ouw.getCloneMapping().entrySet()) {
        if (entity.getKey().getClass().equals(clazz)) {
            count++;
        }
    }
    return count;
}