import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheTest {
    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder().build();
        int counter = 0;
        while(true){
            cache.put("key"+counter++,"value");
            System.out.println("size:"+cache.size());
        }
    }
}