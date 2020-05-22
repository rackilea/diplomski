// Code in process 1
Config cfg = new Config();
HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
Map<Integer, String> sharedData = instance.getMap("shared");
sharedData.put(1, "This is shared data");

// Code in process 2
Config cfg = new Config();
HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
Map<Integer, String> sharedData = instance.getMap("shared");
String theSharedString = sharedData.get(1);