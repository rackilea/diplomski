import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Ordering;

public final class Sorting {
    private Sorting() {}

    public static <T extends Comparable<? super T>> List<List<T>> rank(
            Iterable<T> iterable, int nRanks) {
        if (nRanks < 0) {
            throw new IllegalArgumentException(Integer.toString(nRanks));
        }
        if (nRanks == 0) {
            return new ArrayList<List<T>>();
        }

        Iterator<T> iter = Ordering.natural().sortedCopy(iterable).iterator();
        List<List<T>> ret = new ArrayList<List<T>>();
        if (iter.hasNext()) {
            T prev = iter.next();
            List<T> group = new ArrayList<T>();
            group.add(prev);
            ret.add(group);

            int rank = 1;
            while (iter.hasNext()) {
                T next = iter.next();
                if (prev.compareTo(next) > 0) {
                    rank++;
                    if (rank > nRanks) {
                        break;
                    }

                    group = new ArrayList<T>();
                    ret.add(group);
                }
                group.add(next);
                prev = next;
            }
        }

        return ret;
    }
}