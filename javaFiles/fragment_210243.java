package com.stackoverflow.haylem.sublists;

import java.util.ArrayList;
import java.util.List;

public class SubLists {

  public static <T> List<List<T>> partition(List<T> l, final int nPartitions) {
    final List<List<T>> partitions = new ArrayList<List<T>>(nPartitions);
    final int           nElements  = l.size() / nPartitions; // number of elements per full partition
    final int           nRest      = l.size() % nElements;   // size of the last partition (if any)

    for (int i = 0; i < nPartitions; i++) { // create our nPartitions partitions
      partitions.add(l.subList(             // one subList per partition
          i * nElements,
          i * nElements + nElements
      ));
    }
    if (nRest > 0) {                        // remainder sublist
      partitions.add(l.subList(
          nPartitions * nElements,
          (nPartitions * nElements) + nRest));
    }
    return (partitions);
  }

  /**
   * Generates a dummy list for testing
   */
  public static List<String>      generateStringList(final int size) {
    final List<String> data = new ArrayList<String>(size);

    for (int i = 0; i < 129; i++) {
      data.add("String " + i);
    }
    return (data);
  }

  /**
   * Prints out all the sublists to visualize partitioning
   */
  public static <T> void          printSubLists(final List<List<T>> sLists) {
    for (int i = 0; i < sLists.size(); i++) { // iterates over all sublists
      System.out.println("partition " + i);
      for (final T element : sLists.get(i)) { // prints out current sublist
        System.out.println(" " + element);    // prints out current element
      }
    }
  }

  public static void              test() {
    final List<String> data = generateStringList(129);

    // splits l in five partitions and
    // prints out 5 partitions of 25 elements and 1 of 4
    printSubLists(partition(data, 5));

    // splits l in partitions of 4 or less elements and
    // prints out 32 partitions of 4 elements and 1 of 1
    printSubLists(partition(data, data.size() / 4));
  }

}