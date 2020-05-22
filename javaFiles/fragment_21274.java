/**
 * Returns the sorted EXOR of two sorted int arrays (descending). Uses
 * arrays, index management, and System.arraycopy.
 * @author paislee
 */
int[] arrExor(int[] a1, int[] a2) {

    // eventual result, intermediate (oversized) result
    int[] exor, exor_builder = new int[a1.length + a2.length];
    int exor_i = 0; // the growing size of exor set

    int a1_i = 0, a2_i = 0; // input indices
    int a1_curr, a2_curr; // elements we're comparing

    // chew both input arrays, greedily populating exor_builder
    while (a1_i < a1.length && a2_i < a2.length) {

        a1_curr = a1[a1_i];
        a2_curr = a2[a2_i];

        if (a1_curr != a2_curr) {
            if (a1_curr > a2_curr)
                exor_builder[exor_i++] = a1[a1_i++];
            else
                exor_builder[exor_i++] = a2[a2_i++];
        } else {
            a1_i++;
            a2_i++;
        }        
    }

    // copy remainder into exor_builder
    int[] left = null; // alias for the unfinished input
    int left_i = 0, left_sz = 0; // index alias, # elements left

    if (a1_i < a1.length) {
        left = a1;
        left_i = a1_i;
    } else {
        left = a2;
        left_i = a2_i;
    }

    left_sz = left.length - left_i;
    System.arraycopy(left, left_i, exor_builder, exor_i, left_sz);
    exor_i += left_sz;

    // shrinkwrap and deliver
    exor = new int[exor_i];
    System.arraycopy(exor_builder, 0, exor, 0, exor_i);
    return exor;
}