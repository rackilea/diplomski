public void radixSort(Queue<Integer> sequence) {
    /* Make queues for values with a 0 in the current position and values with a
     * 1 in the current position.  It's an optimization to put these out here;
     * they honestly could be declared inside the loop below.
     */
    Queue<Integer> zero = new LinkedList<Integer>(),
                   one  = new LinkedList<Integer>();

    /* We're going to need 32 rounds of this, since there are 32 bits in each
     * integer.
     */
    for (int i = 0; i < 32; i++) {
        /* Distribute all elements from the input queue into the zero and one
         * queue based on their bits.
         */
        while (!sequence.isEmpty()) {
            Integer curr = sequence.remove();

            /* Determine whether the current bit of the number is 0 or 1 and
             * place the element into the appropriate queue.
             */
            if ((curr >>> i) % 2 == 0) {
                zero.add(curr);
            } else {
                one.add(curr);
            }
        }

        /* Combine the elements from the queues back together.  As a quick
         * note - if this is the 31st bit, we want to put back the 1 elements
         * BEFORE the 0 elements, since the sign bit is reversed.
         */
        if (i == 31) {
            Queue<Integer> temp = zero;
            zero = one;
            one = temp;
        }
        while (!zero.isEmpty()) result.add(zero.remove());
        while (!one.isEmpty())  result.add(one.remove());
    }
}