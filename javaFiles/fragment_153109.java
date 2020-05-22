public abstract class AbstractCachedSupport<T extends Serializable> {
    // ...
}

public class CachedMap<T extends Map<String, Integer> & Serializable>
        extends AbstractCachedSupport<T> {
    // ...
}