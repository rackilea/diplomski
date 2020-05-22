import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;

/**
 *
 * @author mimkorn
 */
public class TypedMultimap extends ForwardingMultimap<Class, Object> {

    private final HashMultimap<Class, Object> delegate;

    public TypedMultimap() {
        this.delegate = HashMultimap.create();
    }


   // IMPORTANT PART
    public <T> Collection<T> getSafely(Class<T> key) {
        return (Collection<T>) delegate().get(key);
    }

    public <T> boolean putSafely(
            Class<T> key, T value) {
        return delegate.put(key, value);
    }
   // TILL HERE    

   // CONVENIENCE
    public <T> boolean putSafely(T value) {
        return delegate.put(value.getClass(), value);
    }
   // TILL HERE

    @Override
    public Collection<Object> get(Class key) {
        return getSafely(key);
    }

    @Override
    public boolean put(Class key, Object value) {
        return putSafely(key, value);
    }

    @Override
    protected Multimap<Class, Object> delegate() {
        return delegate;
    }

}