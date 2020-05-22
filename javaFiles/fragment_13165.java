static int FindRoot(int no1, int no2) {
    int res = 0;
    int x = 0;

    // Ignore squares less than no1
    while(x*x < no1) {
        x++;
    }

    // Count squares up to and including no2
    while(x*x <= no2) {
        res++;
        x++;
    }

    return res;
}