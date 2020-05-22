package hashmaptest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HashMapTest {

    private static final List<Result> results = new ArrayList<Result>();

    public static void main(String[] args) throws IOException {

        //First entry of each array is the sample collection size, subsequent entries
        //are the hash limits
        final int[][] sampleSizesAndHashLimits = new int[][] {
            {100, 50, 90, 100},
            {1000, 500, 900, 990, 1000},
            {100000, 10000, 90000, 99000, 100000}
        };
        final double[] initialCapacityFactors = new double[] {0.5, 0.75, 1.0, 1.25, 1.5, 2.0};
        final float[] loadFactors = new float[] {0.5f, 0.75f, 1.0f, 1.25f};

        //Doing a warmup run to eliminate JIT influence
        for(int[] sizeAndLimits : sampleSizesAndHashLimits) {
            int size = sizeAndLimits[0];
            for(int i = 1; i < sizeAndLimits.length; ++i) {
                int limit = sizeAndLimits[i];
                for(double initCapacityFactor : initialCapacityFactors) {
                    for(float loadFactor : loadFactors) {
                        runTest(limit, size, initCapacityFactor, loadFactor);
                    }
                }
            }

        }

        results.clear();

        //Now for the real thing...
        for(int[] sizeAndLimits : sampleSizesAndHashLimits) {
            int size = sizeAndLimits[0];
            for(int i = 1; i < sizeAndLimits.length; ++i) {
                int limit = sizeAndLimits[i];
                for(double initCapacityFactor : initialCapacityFactors) {
                    for(float loadFactor : loadFactors) {
                        runTest(limit, size, initCapacityFactor, loadFactor);
                    }
                }
            }

        }

        Collections.sort(results);

        for(final Result result : results) {
            result.printSummary();
        }

//      ResultVisualizer.visualizeResults(results);

    }

    private static void runTest(final int hashLimit, final int sampleSize,
            final double initCapacityFactor, final float loadFactor) {

        final int initialCapacity = (int)(sampleSize * initCapacityFactor);

        System.out.println("Running test for a sample collection of size " + sampleSize 
            + ", an initial capacity of " + initialCapacity + ", a load factor of "
            + loadFactor + " and keys with a hash code limited to " + hashLimit);
        System.out.println("====================");

        double hashOverload = (((double)sampleSize/hashLimit) - 1.0) * 100.0;

        System.out.println("Hash code overload: " + hashOverload + "%");

        //Generating our sample key collection.
        final List<Key> keys = generateSamples(hashLimit, sampleSize);

        //Generating our value collection
        final List<Object> values = generateValues(sampleSize);

        final HashMap<Key, Object> map = new HashMap<Key, Object>(initialCapacity, loadFactor);

        final long startPut = System.nanoTime();

        for(int i = 0; i < sampleSize; ++i) {
            map.put(keys.get(i), values.get(i));
        }

        final long endPut = System.nanoTime();

        final long putTime = endPut - startPut;
        final long averagePutTime = putTime/(sampleSize/10);

        System.out.println("Time to map all keys to their values: " + putTime + " ns");
        System.out.println("Average put time per 10 entries: " + averagePutTime + " ns");

        final long startGet = System.nanoTime();

        for(int i = 0; i < sampleSize; ++i) {
            map.get(keys.get(i));
        }

        final long endGet = System.nanoTime();

        final long getTime = endGet - startGet;
        final long averageGetTime = getTime/(sampleSize/10);

        System.out.println("Time to get the value for every key: " + getTime + " ns");
        System.out.println("Average get time per 10 entries: " + averageGetTime + " ns");

        System.out.println("");

        final Result result = 
            new Result(sampleSize, initialCapacity, loadFactor, hashOverload, averagePutTime, averageGetTime, hashLimit);

        results.add(result);

        //Haha, what kind of noob explicitly calls for garbage collection?
        System.gc();

        try {
            Thread.sleep(200);
        } catch(final InterruptedException e) {}

    }

    private static List<Key> generateSamples(final int hashLimit, final int sampleSize) {

        final ArrayList<Key> result = new ArrayList<Key>(sampleSize);

        for(int i = 0; i < sampleSize; ++i) {
            result.add(new Key(i, hashLimit));
        }

        return result;

    }

    private static List<Object> generateValues(final int sampleSize) {

        final ArrayList<Object> result = new ArrayList<Object>(sampleSize);

        for(int i = 0; i < sampleSize; ++i) {
            result.add(new Object());
        }

        return result;

    }

    private static class Key {

        private final int hashCode;
        private final int id;

        Key(final int id, final int hashLimit) {

            //Equals implies same hashCode if limit is the same
            //Same hashCode doesn't necessarily implies equals

            this.id = id;
            this.hashCode = id % hashLimit;

        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        @Override
        public boolean equals(final Object o) {
            return ((Key)o).id == this.id;
        }

    }

    static class Result implements Comparable<Result> {

        final int sampleSize;
        final int initialCapacity;
        final float loadFactor;
        final double hashOverloadPercentage;
        final long averagePutTime;
        final long averageGetTime;
        final int hashLimit;

        Result(final int sampleSize, final int initialCapacity, final float loadFactor, 
                final double hashOverloadPercentage, final long averagePutTime, 
                final long averageGetTime, final int hashLimit) {

            this.sampleSize = sampleSize;
            this.initialCapacity = initialCapacity;
            this.loadFactor = loadFactor;
            this.hashOverloadPercentage = hashOverloadPercentage;
            this.averagePutTime = averagePutTime;
            this.averageGetTime = averageGetTime;
            this.hashLimit = hashLimit;

        }

        @Override
        public int compareTo(final Result o) {

            final long putDiff = o.averagePutTime - this.averagePutTime;
            final long getDiff = o.averageGetTime - this.averageGetTime;

            return (int)(putDiff + getDiff);
        }

        void printSummary() {

            System.out.println("" + averagePutTime + " ns per 10 puts, "
                + averageGetTime + " ns per 10 gets, for a load factor of "
                + loadFactor + ", initial capacity of " + initialCapacity
                + " for " + sampleSize + " mappings and " + hashOverloadPercentage 
                + "% hash code overload.");

        }

    }

}