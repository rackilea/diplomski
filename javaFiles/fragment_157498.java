LinkedList<Integer> unsorted = new LinkedList<Integer>();
unsorted.add(200);
unsorted.add(100);
unsorted.add(300);
SortedLinkedList<Integer> sorted = new SortedLinkedList<Integer>(unsorted);
System.out.println(sorted.size());
for (Integer i : sorted) {
   System.out.println(i);
}
// Should print out:
// 3
// 100
// 200
// 300