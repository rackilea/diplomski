package com.hiveit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pair<L extends Comparable<L>, R extends Comparable<R>> implements Comparable<Pair<L, R>> {

  L left;
  R right;

  public Pair(final L left, final R right) {
    this.left = left;
    this.right = right;
  }

  public L getLeft() {
    return left;
  }

  public R getRight() {
    return right;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (left == null ? 0 : left.hashCode());
    result = prime * result + (right == null ? 0 : right.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Pair<?, ?> other = (Pair<?, ?>) obj;
    if (left == null) {
      if (other.left != null) {
        return false;
      }
    } else if (!left.equals(other.left)) {
      return false;
    }
    if (right == null) {
      if (other.right != null) {
        return false;
      }
    } else if (!right.equals(other.right)) {
      return false;
    }
    return true;
  }

  @Override
  public int compareTo(final Pair<L, R> other) {

    final int compareLeft = left.compareTo(other.left);

    if (compareLeft != 0) {
      return compareLeft;
    }

    return right.compareTo(other.right);
  }

  @Override
  public String toString() {
    return "Pair [left=" + left + ", right=" + right + "]";
  }

  public static String listToString(final List<?> list) {
    return list.stream().map((pair) -> {
      return pair.toString();
    }).collect(Collectors.joining(", "));
  }

  public static void main(final String[] args) {

    final List<Pair<Integer, Integer>> a = new ArrayList<>();

    a.add(new Pair<>(1, 1));
    a.add(new Pair<>(2, 1));
    a.add(new Pair<>(2, 3));
    a.add(new Pair<>(1, 2));
    a.add(new Pair<>(1, 3));
    a.add(new Pair<>(2, 2));

    final List<Pair<Integer, Integer>> sortedByKey = new ArrayList<>(a);
    sortedByKey.sort((o1, o2) -> {
      return o1.getLeft().compareTo(o2.getLeft());
    });

    sortedByKey.stream().map((pair) -> {
      return pair.toString();
    }).collect(Collectors.joining(", "));

    final List<Pair<Integer, Integer>> sortedByValue = new ArrayList<>(a);
    sortedByValue.sort((o1, o2) -> {
      return o1.getRight().compareTo(o2.getRight());
    });

    final List<Pair<Integer, Integer>> sortedByKeyAndValue = new ArrayList<>(a);
    sortedByKeyAndValue.sort((o1, o2) -> {
      return o1.compareTo(o2);
    });

    System.out.println("Original                  = " + listToString(a));
    System.out.println("Sorted by Left            = " + listToString(sortedByKey));
    System.out.println("Sorted by Right           = " + listToString(sortedByValue));
    System.out.println("Sorted by Left then Right = " + listToString(sortedByKeyAndValue));

  }
}