public double DoubleSegsum(double[] a, int from, int to){
    double sum = 0;
    for (int i = from; i < to && i < a.length; i++) {
        sum += a[i];
    }

    return sum;
}