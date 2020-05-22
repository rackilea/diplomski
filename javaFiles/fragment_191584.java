public void track(final ip) {
    try {
        if(ip != null) {
            executor.execute(new IncrementCounterDistributedTask<>(ip, IP_MAP_NAME));
        }
    } catch (RejectedExecutionException ignored) {
    }
}

private static class IncrementCounterDistributedTask<K> implements Runnable, PartitionAware, Serializable {

    private final K key;
    private final String mapName;

    public IncrementCounterDistributedTask(K key, String mapName) {
        this.key = key;
        this.mapName = mapName;
    }

    @Override
    public Object getPartitionKey() {
        return key;
    }

    @Override
    public void run() {
        IMap<K, Integer> map = Hazelcast.getMap(mapName);
        map.lock(key);
        Integer counter = map.get(key);
        if(counter == null) {
            map.put(key, 1);
        } else {
            map.put(key, ++counter);
        }
        map.unlock(key);
    }
}