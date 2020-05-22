import java.util.HashMap;
import java.util.Map;
...
Map<String, Integer> freq = new HashMap<String, Integer>();
...
int count = freq.containsKey(word) ? freq.get(word) : 0;
freq.put(word, count + 1);