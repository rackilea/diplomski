import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;

static void sortByIndices(List<String[]> list, int first, int... rest) {
    Comparator<String[]> comparator = comparing(array -> array[first]);
    for (int index : rest) {
        comparator = comparator.thenComparing(array -> array[index]);
    }
    list.sort(comparator);
}