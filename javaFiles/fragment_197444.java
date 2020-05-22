public void bogosort(Queue<Integer> sequence, Random r) {
    while (!isSorted(sequence)) {
        permute(sequence, r);
    }
}

/* Checking if a sequence is sorted is tricky because we have to destructively modify
 * the queue.  Our process will be to cycle the elements of the sequence making sure
 * that each element is greater than or equal to the previous element.
 *
 * Because we are using bogosort, it's totally fine for us to destructively modify
 * the queue as long as all elements that were in the original input queue end up
 * in the resulting queue.  We'll do this by cycling forward through the elements
 * and stopping if we find something mismatched.
 */
private void isSorted(Queue<Integer> sequence) {
    int last = Integer.MIN_VALUE;

    for (int i = 0; i < sequence.size(); i++) {
        int curr = sequence.remove();
        sequence.add(curr);

        if (curr < last) return false;
    }
    return true;
}

/* Randomly permutes the elements of the given queue. */
private void permute(Queue<Integer> sequence, Random r) {
    /* Buffer queue to hold the result. */
    Queue<Integer> result = new LinkedList<Integer>();

    /* Continuously pick a random element and add it. */
    while (!sequence.isEmpty()) {
        /* Choose a random index and cycle forward that many times. */
        int index = r.nextInt(sequence.size());
        for (int i = 0; i < index; i++) {
            sequence.add(sequence.remove());
        }
        /* Add the front element to the result. */
        result.add(sequence.remove());
    }

    /* Transfer the permutation back into the sequence. */
    while (!result.isEmpty()) sequence.add(result.remove());
}