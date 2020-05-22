// Java 8
public long countCachedEntitiesL1(Class clazz) {
    return ouw.getCloneMapping().keySet().stream()
        .filter(entity -> entity.getClass().equals(clazz))
        .count();
}