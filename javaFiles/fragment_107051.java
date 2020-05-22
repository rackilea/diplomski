import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset;

public class Inventory {
    private final Multiset<String> countingSet = ConcurrentHashMultiset.create();

    public void add(String key, int count) {
        countingSet.add(key, count);
    }

    public int keyCount(String keyString) {
        return countingSet.count(keyString);
    }

    public static void main(String[] args) {
        Inventory ex = new Inventory();
        ex.add("Item One", 5);
        ex.add("Item Three", 25);
        ex.add("Item Four", 35);
        ex.add("Item Two", 15);
        ex.add("Item One", 5);
        ex.add("Item Two", 15);
        ex.add("Item Three", 25);
        ex.add("Item Four", 35);
        System.out.println(ex.keyCount("Wooden Sword"));
        System.out.println(ex.keyCount("Item Three"));
    }
}