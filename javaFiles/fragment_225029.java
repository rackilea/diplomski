import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSorter {

    public static void main(String[] args) {
        List<String> values = new ArrayList<>(25);
        values.add("12,Vanilla granola bar,91");
        values.add("1,Vanilla granola bar,91");
        values.add("50,Vanilla granola bar,91");
        values.add("25,Vanilla granola bar,91");
        values.add("13,Vanilla granola bar,91");

        dump(values);

        Collections.sort(values, new SplitComparator());

        dump(values);
    }

    protected static void dump(List<String> values) {
        System.out.println(values);
    }

    public static class SplitComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int i1 = getIndex(o1);
            int i2 = getIndex(o2);

            return i1 - i2;
        }

        protected int getIndex(String o1) {
            return Integer.parseInt(o1.split(",")[0]);
        }
    }
}