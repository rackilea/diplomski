import java.util.*;

public class E {

    public static void main(String[] args) {
        Random r = new Random();
        Map<Integer,Integer> runs = new TreeMap<>();
        int last = -1;
        int run = 0;
        for (int i = 0; i < 81; ++i) {
            int v = r.nextInt(3);
            if (v != last) {
                if (i != 0) {
                    if (runs.containsKey(run)) {
                        runs.put(run, runs.get(run) + 1);
                    } else {
                        runs.put(run, 1);
                    }
                    System.out.println(" (" + run + ")");
                }
                last = v;
                run = 0;
            }
            ++run;
            System.out.print(v);
        }
        System.out.println("\n****");
        for (Map.Entry e : runs.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}