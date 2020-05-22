import java.util.HashMap;
import java.util.Map;
...
class MutableInt {
  int value = 1; // note that we start at 1 since we're counting
  public void increment () { ++value;      }
  public int  get ()       { return value; }
}
...
Map<String, MutableInt> freq = new HashMap<String, MutableInt>();
...
MutableInt count = freq.get(word);
if (count == null) {
    freq.put(word, new MutableInt());
}
else {
    count.increment();
}