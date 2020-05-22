public static float T1(int n, float y) {
    if (n==0) return y;
    if (n==1) return 1;
    float p1 = 1, p2 = y; // track the previous two values
    for (int i=2; i <= n; ++i) {
        float p = 2*y*p1 - p2; // calculate the result for this iteration
        p2 = p1; // update the previous values to be used in the next iteration
        p1 = p;
    }
    return p1;
}