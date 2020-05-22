public static void bitwiseMultiply(int n1, int n2) {
    /* This value will hold n1 * 2^i for varying values of i.  It will
     * start off holding n1 * 2^0 = n1, and after each iteration will 
     * be updated to hold the next term in the sequence.
     */
    int a = n1;

    /* This value will be used to read the individual bits out of n2.
     * We'll use the shifting trick to read the bits and will maintain
     * the invariant that after i iterations, b is equal to n2 >> i.
     */
    int b = n2;

    /* This value will hold the sum of the terms so far. */
    int result = 0;

    /* Continuously loop over more and more bits of n2 until we've
     * consumed the last of them.  Since after i iterations of the
     * loop b = n2 >> i, this only reaches zero once we've used up
     * all the bits of the original value of n2.
     */
    while (b != 0)
    {
        /* Using the bitwise AND trick, determine whether the ith 
         * bit of b is a zero or one.  If it's a zero, then the
         * current term in our sum is zero and we don't do anything.
         * Otherwise, then we should add n1 * 2^i.
         */
        if ((b & 1) != 0)
        {
            /* Recall that a = n1 * 2^i at this point, so we're adding
             * in the next term in the sum.
             */
            result = result + a;
        }

        /* To maintain that a = n1 * 2^i after i iterations, scale it
         * by a factor of two by left shifting one position.
         */
        a <<= 1;

        /* To maintain that b = n2 >> i after i iterations, shift it
         * one spot over.
         */
        b >>>= 1;
    }

    System.out.println(result);
}