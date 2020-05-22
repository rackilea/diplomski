//You need to add casting exception handling, no argument situation etc...
    public class HashMapFactory<T, V> { 
        public HashMap<T, V> create(Object... arg) {
            HashMap<T, V> map = new HashMap<T, V>();

            for(int i = 1; i < arg.length; i+=2) {
                map.put((T)arg[i-1], (V)arg[i]);
            }

            return map;
        }
    }