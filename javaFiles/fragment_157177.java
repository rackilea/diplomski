public class Cache {
     private Map<Integer, Map<Integer, List<String>>> map;

     public Cache(args) {
     }

     public synchronized Map<Integer, Map<Integer, List<String>>> getMap() {
          return map;
     }

     // called by a thread every 30 seconds.
     public void updateCache() {
          Map<Integer, Map<Integer, List<String>>> newMap = ...
          // build new map, can take seconds.

          // quickly swap in the new map.
          synchronzied(this) {
              map = newMap;
          }
     }
}