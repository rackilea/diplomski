public class CoolMap<K, V> extends HashMap<K, V> {

@Override
public V put(K key, V value) {

    if (size() == 7) {
        throw new IllegalStateException("Size is at max!");
    } else {

        // If there is something already with that key
        if (containsKey(value)) {
            // do nothing
            return value;
        } else {
            // put inside
            return super.put(key, value);
        }

    }

}

@Override
public void putAll(Map<? extends K, ? extends V> collection) {

    if (collection.size() > 7) {
        throw new IllegalStateException("Size is at max!");
    } else {
        super.putAll(collection);
    }

}

@Override
public V remove(Object key) {
    return null;// doesn't remove anything
}