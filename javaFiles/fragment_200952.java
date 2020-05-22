public class CustomMap<K,V> extends Hashtable<K,V> {

     public V put(K key, V value) {
         //perform your operation to register the event
        return super.put(key, value);
     }
}