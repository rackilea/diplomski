public void quicksort(Queue<Integer> sequence) {
    /* Base case: Any 0- or 1-element sequence is trivially sorted. */
    if (sequence.size() <= 1) return;

    /* Choose the first element as the pivot (causes O(n^2) worst-case behavior,
     * but for now should work out fine.  Then, split the list into three groups,
     * one of elements smaller than the pivot, one of elements equal to the
     * pivot, and one of elements greater than the pivot.
     */
    Queue<Integer> pivot = new LinkedList<Integer>(),
                   less  = new LinkedList<Integer>(),
                   more  = new LinkedList<Integer>();

    /* Place the pivot into its list. */
    pivot.add(sequence.remove());

    /* Distribute elements into the queues. */
    while (!sequence.isEmpty()) {
        Integer elem = sequence.remove();
        if      (elem < pivot.peek()) less.add(elem);
        else if (elem > pivot.peek()) more.add(elem);
        else                          pivot.add(elem);
    }

    /* Sort the less and greater groups. */
    quicksort(less);
    quicksort(more);

    /* Combine everything back together by writing out the smaller
     * elements, then the equal elements, then the greater elements.
     */
    while (!less.isEmpty())  result.add(less.remove());
    while (!pivot.isEmpty()) result.add(pivot.remove());
    while (!more.isEmpty())  result.add(more.remove());
}