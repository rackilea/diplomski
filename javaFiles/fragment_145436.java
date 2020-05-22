import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class GenericCachedSorter {
    public static void main(String[] args) {
        List<Double> distances = new ArrayList<>(Arrays.asList(1d, 2d, 3d));

        sort(distances, new ToComparable<Double, Double>() {
            @Override
            public Double toComparable(Double distance) {
                // return the longitude associated with this distance
                return getLongitude(distance);
            }
        });

        for (Double distance : distances)
            System.out.println(distances);
    }

    public interface ToComparable<T, C extends Comparable<? super C>> {
         C toComparable(T t);
    }

    public static <T, C extends Comparable<? super C>> void sort(List<T> list, ToComparable<T, C> function) {
       class Pair implements Comparable<Pair> {
          final T original;
          final C comparable;

          Pair(T original, C comparable) {
             this.original = original;
             this.comparable = comparable;
          }

          @Override
          public int compareTo(Pair other) {
                return
                  comparable == null && other.comparable == null ? 0 :
                  comparable == null ? -1 :
                  other.comparable == null ? 1 :
                  comparable.compareTo(other.comparable);
          }
       }

       List<Pair> pairs = new ArrayList<>(list.size());
       for (T original : list)
          pairs.add(new Pair(original, function.toComparable(original)));

       Collections.sort(pairs);

       ListIterator<T> iter = list.listIterator();
       for (Pair pair : pairs) {
          iter.next();
          iter.set(pair.original);
       }
    }
}