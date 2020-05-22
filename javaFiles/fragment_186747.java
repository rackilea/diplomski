assert (high2-low2==high1-low1); // sanity check
    int n=high1-low1+1; // "n" from logic

    int m1 = median(array1,low1,high1);
    int m2 = median(array2,low2,high2);

    int low1_t = low1;
    int high1_t = high1;
    int low2_t = low2;
    int high2_t = high2;

    if(m1 == m2) {
        return m1;
    } else if(m1 > m2) {
        if (n % 2 == 0) {
            high1_t = high1-n/2+1;
            low2_t = low2+n/2-1;
        } else {
            high1_t = high1-n/2;
            low2_t = low2+n/2;
        }
    } else {
        if (n % 2 == 0) {
            low1_t = low1+n/2-1;
            high2_t = high2-n/2+1;
        } else {
            low1_t = low1+n/2;
            high2_t = high2-n/2;
        }
    }
    return findMedian(array1, array2, low1_t, high1_t, low2_t, high2_t);