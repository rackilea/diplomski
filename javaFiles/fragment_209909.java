public class ReversibleMap {
       private final Map keyToValue = new HashMap(8);
       private final Map valueToKey = new HashMap(8);

       public void put(Integer key, String value) {
           keyToValue.put(key, value);
           valueToKey.put(value, key);
       }

       public String get(Integer key) {
           return (String) keyToValue.get(key);
       }

       public Integer getKey(String value) {
           return (Integer) valueToKey.get(value);
      }
   }