import java.util.Map;
import java.util.Set;

public interface StringBackedMap<K, V> extends Map<K, V> {

    public V get(String key);

    public boolean containsKey(String key);

    public Set<Entry<String, V>> backerEntrySet();

    public Set<String> backerKeySet();

}