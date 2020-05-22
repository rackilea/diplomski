public void deleteByKey(K key) {
    T object = findByKey(key);
    liveObjectService.delete(object);
}

private T findByKey(K key) {
    return liveObjectService.get(type, key);
}