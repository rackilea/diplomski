HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    Map<Integer, String> map = hz.getMap("yourMap");
    for (int key = 0; key < 100; key++)
        map.put(key, "someValue");
    IExecutorService executor = hz.getExecutorService("executor");
    for (Integer key : map.keySet())
        executor.executeOnKeyOwner(new YourBigTask(), key);