public int soltuion(int n) {
    int curr = 0;
    int max = 0;

    while (n > 0) {
        int bit = n & 1;
        n >>= 1;
        if (bit == 1) {
            if (curr > max) {
                max = curr;
            }
            curr = 0;
        } else {
            curr++;
        }
    }

    return max;
}