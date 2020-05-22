LinkedList<Integer> l = new LinkedList<Integer>();
l.add(1);
l.add(2);
l.add(3);

Iterator i = l.descendingIterator();
while(i.hasNext()) {
    System.out.print(i.next() + " ");
}