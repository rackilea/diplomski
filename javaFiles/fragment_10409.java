package se.wederbrand.stackoverflow;

import java.util.ArrayList;

public class HeapSort {
  static int[] numbers = new int[]{0, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
  static ArrayList<Integer> heap = new ArrayList<Integer>();

  public static void main(String[] args) {
    // add 0 at the first position
    heap.add(0);
    for (int i = 1; i < numbers.length; i++) {
      heap.add(numbers[i]);
      if (i > 1) {
        reheapifyBottomUp(i);
      }
    }
    while (heap.size() > 1) {
      System.out.println(removeFirstFromHeap());
    }
  }

  private static int removeFirstFromHeap() {
    // the value at index 1 should be returned
    int returnValue = heap.get(1);

    // the last node is replacing the removed one
    if (heap.size() > 2) {
      heap.set(1, heap.remove(heap.size() - 1));
      reheapifyTopDown(1);
    }
    else {
      heap.remove(1);
    }

    return returnValue;
  }

  public static void reheapifyBottomUp(int childLocation) {
    int parentLocation = childLocation / 2;

    int parentValue = heap.get(parentLocation);
    int childValue = heap.get(childLocation);

    if (parentValue > childValue) {
      heap.set(parentLocation, childValue);
      heap.set(childLocation, parentValue);
    }
    if (parentLocation != 1) {
      reheapifyBottomUp(parentLocation);
    }
  }

  public static void reheapifyTopDown(int parentLocation) {
    int childLocation1 = parentLocation * 2;
    int childLocation2 = childLocation1 + 1;

    int parentValue = heap.get(parentLocation);
    int childValue1 = Integer.MAX_VALUE;
    if (heap.size() > childLocation1) {
      childValue1 = heap.get(childLocation1);
    }
    int childValue2 = Integer.MAX_VALUE;
    if (heap.size() > childLocation2) {
      childValue2 = heap.get(childLocation2);
    }

    if (childValue1 <= childValue2 && parentValue > childValue1) {
      // swap them and continue down
      heap.set(parentLocation, childValue1);
      heap.set(childLocation1, parentValue);
      reheapifyTopDown(childLocation1);
    }
    else if (childValue2 < childValue1 && parentValue > childValue2) {
      // swap them and continue down
      heap.set(parentLocation, childValue2);
      heap.set(childLocation2, parentValue);
      reheapifyTopDown(childLocation2);
    }
  }
}