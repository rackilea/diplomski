package forums;

import java.util.Set;
import java.util.Map;
import java.util.WeakHashMap;
import krc.utilz.Random;

public class WeakCache<K,V> extends WeakHashMap<K,V>
{
  private static final int NUM_ITEMS = 2000;
  private static final Random RANDOM = new Random();

  private static void runTest() {
    Map<String, String> cache = new WeakCache<String, String>();
    String key; // Let's retain a reference to the last key object
    for (int i=0; i<NUM_ITEMS; ++i ) {
      /*String*/ key = RANDOM.nextString();
      cache.put(key, RANDOM.nextString());
    }

    System.out.println("There are " + cache.size() + " items of " + NUM_ITEMS + " in the cache before GC.");

    // try holding a reference to the keys
    Set<String> keys = cache.keySet();
    System.out.println("There are " + keys.size() + " keys");

    // a hint that now would be a good time to run the GC. Note that this
    // does NOT guarantee that the Garbage Collector has actually run, or
    // that it's done anything if it did run!
    System.gc();

    System.out.println("There are " + cache.size() + " items of " + NUM_ITEMS + " remaining after GC");
    System.out.println("There are " + keys.size() + " keys");
  }

  public static void main(String[] args) {
    try {
      for (int i=0; i<20; ++i ) {
        runTest();
        System.out.println();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}