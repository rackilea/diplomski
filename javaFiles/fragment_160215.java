import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
...
final ConcurrentMap<String, AtomicLong> map = 
    new ConcurrentHashMap<String, AtomicLong>();
...
map.putIfAbsent(word, new AtomicLong(0));
map.get(word).incrementAndGet();