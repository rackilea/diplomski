public static void main (String[] args) throws java.lang.Exception {
    Integer arr[] = {2, 6, 5, 3, 7, 9, 12, 35, 1, 3};
    List<Integer> incoming = Arrays.asList(arr);
    Comparator<Integer> maxFirstComparator = (x, y) -> Integer.compare(y,x);
    printList(getMinOrMaxKNumbers(incoming, 3, null));
    System.out.println();
    printList(getMinOrMaxKNumbers(incoming, 3, maxFirstComparator));
}

/*
 * gets the max/min K elements from the List
 * @param comparator    if null is passed the method uses natural ordering
 *
 */
private static List<Integer> getMinOrMaxKNumbers(List<Integer> incoming, int k, Comparator<Integer> comparator) {
    int n = incoming.size();
    PriorityQueue<Integer> pq = comparator == null ? new PriorityQueue<>(n) : new PriorityQueue<>(n, comparator);

    for (int i : incoming) {
        pq.add(i);
    }

    List<Integer> outgoing = new ArrayList<>(k);
    for (int i = 0; i < k; i++) {
        outgoing.add(pq.poll());
    }

    return outgoing;
}

private static void printList(List<Integer> list) {
    list.stream().forEach(x -> System.out.print(x + " "));
}