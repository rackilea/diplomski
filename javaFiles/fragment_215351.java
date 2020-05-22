public class ListenerSample {
    public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();

        IMap<String, String> map = hz.getMap("myMap");

        MyMapEventLogger myMapEventLogger= new MyMapEventLogger();
        map.addEntryListener(myMapEventLogger, true);

        // Put, modify and then clear
        map.put("1", "1");
        map.put("1", "2");
        map.clear();
    }
}