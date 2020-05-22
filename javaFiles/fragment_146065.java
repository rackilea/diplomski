private static double computePiOver2(int n) {
    double prod = 1.0;
    int reps = 0;

    if(reps == n)
        return prod;
    else {
        reps += 1;
        return 2.0*n/(2*n-1)*(2.0*n/(2*n+1)) * computePiOver2(n-1);
    }
}