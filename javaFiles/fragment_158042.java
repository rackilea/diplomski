import java.util.HashMap;
import java.util.Map;

public class Count<K, V> extends HashMap<K, V> {

    // Counts unique objects
    public void add(K o) {
        int count = this.containsKey(o) ? ((Integer)this.get(o)).intValue() + 1 : 1;
        super.put(o, (V) new Integer(count));
    }

    // Demonstration
    public static void main(String[] args) {

        Count<Object, Integer> c = new Count<Object, Integer>();

        String one = "one";
        String two = "two";
        String six = "six";

        c.add(one);
        c.add(two);
        c.add(two);
        c.add(six);
        c.add(six);
        c.add(six);

        System.out.println("Number of distinct objects: " + c.size());

        System.out.println("Frequency of different objects: ");

        for (Map.Entry<Object, Integer> entry : c.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}