LinkedList<Integer> unsorted = new LinkedList<Integer>();
unsorted.add(200);
unsorted.add(100);
unsorted.add(300);
SortedLinkedList<Integer> sorted = new SortedLinked<Integer>(unsorted);
System.out.println(sorted.get(0));