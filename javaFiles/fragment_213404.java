import java.util.LinkedList;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.collections.ObservableListBase;

public class CachedObservableList<T> extends ObservableListBase<T> {

    private final int maxCacheSize ;
    private int cacheStartIndex ;
    private int actualSize ;
    private final IntFunction<T> generator ;

    private final LinkedList<T> cache ;

    public CachedObservableList(int maxCacheSize, int size, IntFunction<T> generator) {
        this.maxCacheSize = maxCacheSize ;
        this.generator = generator ;

        this.cache = new LinkedList<T>();

        this.actualSize = size ;
    }

    @Override
    public T get(int index) {

        int debugCacheStart = cacheStartIndex ;
        int debugCacheSize = cache.size(); 

        if (index < cacheStartIndex) {
            // evict from end of cache:
            int numToEvict = cacheStartIndex + cache.size() - (index + maxCacheSize);
            if (numToEvict < 0) {
                numToEvict = 0 ;
            }
            if (numToEvict > cache.size()) {
                numToEvict = cache.size();
            }
            cache.subList(cache.size() - numToEvict, cache.size()).clear();

            // create new elements:
            int numElementsToCreate = cacheStartIndex - index ;
            if (numElementsToCreate > maxCacheSize) {
                numElementsToCreate = maxCacheSize ;
            }
            cache.addAll(0, 
                    IntStream.range(index, index + numElementsToCreate)
                    .mapToObj(generator)
                    .collect(Collectors.toList()));

            cacheStartIndex = index ;

        } else if (index >= cacheStartIndex + cache.size()) {
            // evict from beginning of cache:
            int numToEvict = index - cacheStartIndex - maxCacheSize + 1 ;
            if (numToEvict < 0) {
                numToEvict = 0 ;
            }
            if (numToEvict >= cache.size()) {
                numToEvict = cache.size();
            }

            cache.subList(0, numToEvict).clear();

            // create new elements:

            int numElementsToCreate = index - cacheStartIndex - numToEvict - cache.size() + 1; 
            if (numElementsToCreate > maxCacheSize) {
                numElementsToCreate = maxCacheSize ;
            }

            cache.addAll(
                    IntStream.range(index - numElementsToCreate + 1, index + 1)
                    .mapToObj(generator)
                    .collect(Collectors.toList()));

            cacheStartIndex = index - cache.size() + 1 ;
        }

        try {
            T t = cache.get(index - cacheStartIndex);
            assert(generator.apply(index).equals(t));
            return t ;
        } catch (Throwable exc) {
            System.err.println("Exception retrieving index "+index+": cache start was "+debugCacheStart+", cache size was "+debugCacheSize);
            throw exc ;
        }

    }

    @Override
    public int size() {
        return actualSize ;
    }

}