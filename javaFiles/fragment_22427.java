Iterator<Integer> first = Arrays.asList(countA).iterator();
Iterator<Integer> second = Arrays.asList(countB).iterator();

Iterator<Integer> current = first;
Iterator<Integer> next = second;
while (current.hasNext()) {
    System.out.println(current.next());

    // Swap
    Iterator<Integer> tmp = current;
    current = next;
    next = tmp;
}