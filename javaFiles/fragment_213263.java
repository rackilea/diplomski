package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintPartitionings {
    /** A list of integers */
    public static class Partition extends ArrayList<Integer>
            implements Comparable<Partition> {
        // Lexicographic comparator
        @Override
        public int compareTo(Partition other) {
            for (int i = 0, ii = Math.min(this.size(),
                    other.size()); i < ii; i++) {
                int c = this.get(i).compareTo(other.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(this.size(), other.size());
        }
    }

    /** A list of lists of integers */
    public static class Partitioning extends ArrayList<Partition>
            implements Comparable<Partitioning> {
        public Partitioning() {
            super();
        }

        public Partitioning(int N) {
            super(N);
            // Pre-allocate sub-lists for convenience
            for (int j = 0; j < N; j++) {
                add(new Partition());
            }
        }

        // Lexicographic comparator
        @Override
        public int compareTo(Partitioning other) {
            for (int i = 0, ii = Math.min(this.size(),
                    other.size()); i < ii; i++) {
                int c = this.get(i).compareTo(other.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(this.size(), other.size());
        }
    }

    /** Print all unique partitionings of the passed array of integers */
    public static void printPartitionings(int[] elts) {
        int N = elts.length;
        Set<Partitioning> setOfPartitionings = new HashSet<>();
        // Generate integers in [0, N^N)
        for (long i = 0, ii = (long) Math.pow(N, N); i < ii; i++) {
            // Create empty partitioning
            Partitioning partitioning = new Partitioning(N);

            // Assign each element to a partition based on base N digit
            long digits = i;
            for (int j = 0; j < N; j++) {
                int digit = (int) (digits % N);
                digits /= N;
                partitioning.get(digit).add(elts[j]);
            }

            // Sort individual partitions, and remove empty partitions
            Partitioning partitioningSorted = new Partitioning();
            for (Partition partition : partitioning) {
                if (!partition.isEmpty()) {
                    Collections.sort(partition);
                    partitioningSorted.add(partition);
                }
            }

            // Sort the partitioning
            Collections.sort(partitioningSorted);

            // Add the result to the final set of partitionings
            setOfPartitionings.add(partitioningSorted);
        }

        // Sort lexicographically to make it easier to view the result
        List<Partitioning> setOfPartitioningsSorted = new ArrayList<>(
                setOfPartitionings);
        Collections.sort(setOfPartitioningsSorted);
        for (Partitioning partitioning : setOfPartitioningsSorted) {
            System.out.println(partitioning);
        }
    }

    public static void main(String[] args) {
        printPartitionings(new int[] { 1, 2, 1, 2 });
    }
}