import java.awt.Point;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class ListBenchmark {

    public static void main(String[] args) {
        Random rnd = new SecureRandom();
        Map<String, Long> timings = new TreeMap<String, Long>();
        for (int outerPass = 0; outerPass < 10; ++ outerPass) {
            List<FilterStrategy> strategies =
                Arrays.asList(new CopyIntoNewListWithIterator(),
                              new CopyIntoNewListWithoutIterator(),
                              new FilterLinkedListInPlace(),
                              new RandomRemoveByIndex(),
                              new SequentialRemoveByIndex(),
                              new ShiftDown());
            for (FilterStrategy strategy: strategies) {
                String strategyName = strategy.getClass().getSimpleName();
                for (int innerPass = 0; innerPass < 10; ++ innerPass) {
                    strategy.populate(rnd);
                    if (outerPass >= 5 && innerPass >= 5) {
                        Long totalTime = timings.get(strategyName);
                        if (totalTime == null) totalTime = 0L;
                        timings.put(strategyName, totalTime - System.currentTimeMillis());
                    }
                    Collection<Point> filtered = strategy.filter();
                    if (outerPass >= 5 && innerPass >= 5) {
                        Long totalTime = timings.get(strategyName);
                        timings.put(strategy.getClass().getSimpleName(), totalTime + System.currentTimeMillis());
                    }
                    CHECKSUM += filtered.hashCode();
                    System.err.printf("%-30s %d %d %d%n", strategy.getClass().getSimpleName(), outerPass, innerPass, filtered.size());
                    strategy.clear();
                }
            }
        }
        for (Map.Entry<String, Long> e: timings.entrySet()) {
            System.err.printf("%-30s: %9.2fms%n", e.getKey(), e.getValue() * (1.0/25.0));
        }
    }

    public static volatile int CHECKSUM = 0;

    static void populate(Collection<Point> dst, Random rnd) {
        for (int i = 0; i < INITIAL_SIZE; ++ i) {
            dst.add(new Point(rnd.nextInt(), rnd.nextInt()));
        }
    }

    static boolean wanted(Point p) {
        return p.hashCode() % 20 != 0;
    }

    static abstract class FilterStrategy {
        abstract void clear();
        abstract Collection<Point> filter();
        abstract void populate(Random rnd);
    }

    static final int INITIAL_SIZE = 100000;

    private static class CopyIntoNewListWithIterator extends FilterStrategy {
        public CopyIntoNewListWithIterator() {
            list = new ArrayList<Point>(INITIAL_SIZE);
        }
        @Override
        void clear() {
            list.clear();
        }
        @Override
        Collection<Point> filter() {
            ArrayList<Point> dst = new ArrayList<Point>(list.size());
            for (Point p: list) {
                if (wanted(p)) dst.add(p);
            }
            return dst;
        }
        @Override
        void populate(Random rnd) {
            ListBenchmark.populate(list, rnd);
        }
        private final ArrayList<Point> list;
    }

    private static class CopyIntoNewListWithoutIterator extends FilterStrategy {
        public CopyIntoNewListWithoutIterator() {
            list = new ArrayList<Point>(INITIAL_SIZE);
        }
        @Override
        void clear() {
            list.clear();
        }
        @Override
        Collection<Point> filter() {
            int inputSize = list.size();
            ArrayList<Point> dst = new ArrayList<Point>(inputSize);
            for (int i = 0; i < inputSize; ++ i) {
                Point p = list.get(i);
                if (wanted(p)) dst.add(p);
            }
            return dst;
        }
        @Override
        void populate(Random rnd) {
            ListBenchmark.populate(list, rnd);
        }
        private final ArrayList<Point> list;
    }

    private static class FilterLinkedListInPlace extends FilterStrategy {
        public String toString() {
            return getClass().getSimpleName();
        }
        FilterLinkedListInPlace() {
            list = new LinkedList<Point>();
        }
        @Override
        void clear() {
            list.clear();
        }
        @Override
        Collection<Point> filter() {
            for (Iterator<Point> it = list.iterator();
                 it.hasNext();
                 ) {
                Point p = it.next();
                if (! wanted(p)) it.remove();
            }
            return list;
        }
        @Override
        void populate(Random rnd) {
            ListBenchmark.populate(list, rnd);
        }
        private final LinkedList<Point> list;
    }

    private static class RandomRemoveByIndex extends FilterStrategy {
        public RandomRemoveByIndex() {
            list = new ArrayList<Point>(INITIAL_SIZE);
        }
        @Override
        void clear() {
            list.clear();
        }
        @Override
        Collection<Point> filter() {
            for (int i = 0; i < list.size();) {
                if (wanted(list.get(i))) {
                    ++ i;
                } else {
                    list.remove(i);
                }
            }
            return list;
        }
        @Override
        void populate(Random rnd) {
            ListBenchmark.populate(list, rnd);
        }
        private final ArrayList<Point> list;
    }

    private static class SequentialRemoveByIndex extends FilterStrategy {
        public SequentialRemoveByIndex() {
            list = new LinkedList<Point>();
        }
        @Override
        void clear() {
            list.clear();
        }
        @Override
        Collection<Point> filter() {
            for (int i = 0; i < list.size();) {
                if (wanted(list.get(i))) {
                    ++ i;
                } else {
                    list.remove(i);
                }
            }
            return list;
        }
        @Override
        void populate(Random rnd) {
            ListBenchmark.populate(list, rnd);
        }
        private final LinkedList<Point> list;
    }

    private static class ShiftDown extends FilterStrategy {
        public ShiftDown() {
            list = new ArrayList<Point>();
        }
        @Override
        void clear() {
            list.clear();
        }
        @Override
        Collection<Point> filter() {
            int inputSize = list.size();
            int outputSize = 0;
            for (int i = 0; i < inputSize; ++ i) {
                Point p = list.get(i);
                if (wanted(p)) {
                    list.set(outputSize++, p);
                }
            }
            list.subList(outputSize, inputSize).clear();
            return list;
        }
        @Override
        void populate(Random rnd) {
            ListBenchmark.populate(list, rnd);
        }
        private final ArrayList<Point> list;
    }

}