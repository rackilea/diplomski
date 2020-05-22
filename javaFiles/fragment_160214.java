import java.util.HashMap;
import java.util.Map;
...
Map<String, Integer> freq = new HashMap<String, Integer>();
...
Integer count = freq.get(word);
if (count == null) {
    freq.put(word, 1);
}
else {
    freq.put(word, count + 1);
}