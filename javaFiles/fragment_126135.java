ListIterator<Integer> iter = list.listIterator();
while (iter.hasNext()) {
    int i = itr.next();
    iter.set(null);      // or iter.remove() but that's O(n) instead of O(1)
    // process i
    Thread.sleep(10000); // Simulate lots of work.
}