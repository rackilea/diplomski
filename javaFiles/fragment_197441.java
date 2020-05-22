public void mergesort(Queue<Integer> sequence) {
    /* Base case: Any 0- or 1-element sequence is trivially sorted. */
    if (sequence.size() <= 1) return;

    /* Otherwise, split the sequence in half. */
    Queue<Integer> left  = new LinkedList<Integer>(),
                   right = new LinkedList<Integer>();
    while (!sequence.isEmpty()) {
        left.add(sequence.remove());
        if (!sequence.isEmpty()) {
           right.add(sequence.remove());
        }
    }

    /* Recursively sort both halves. */
    mergesort(left);
    mergesort(right);

    /* Merge them back together. */
    merge(left, right, sequence);
}

private void merge(Queue<Integer> one, Queue<Integer> two,
                   Queue<Integer> result) {
    /* Keep choosing the smaller element. */
    while (!one.isEmpty() && !two.isEmpty()) {
        if (one.peek() < two.peek()) {
            result.add(one.remove());
        } else {
            result.add(two.remove());
        }
    }

    /* Add all elements from the second queue to the result. */
    while (!one.isEmpty()) {
        result.add(one.remove());
    }
    while (!two.isEmpty()) {
        result.add(two.remove());
    }
}