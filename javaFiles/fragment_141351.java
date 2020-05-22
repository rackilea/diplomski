Iterator<Integer> first = li.listIterator();

    // Will raise IndexOutOfBoundsException if list is empty.
    Iterator<Integer> second = li.listIterator(1);

    while (second.hasNext()) {
        System.out.println(first.next() + " " + second.next());
    }