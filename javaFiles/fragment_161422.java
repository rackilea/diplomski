static void getMetric(int[] a, int trials){
    double metric = calcMetricDiff(a[0], trials, 2.0 / 15.0);

    for (int i = 1; i < a.length - 1; i++) {
        metric += calcMetricDiff(a[i], trials, 0.1);
    }   

    metric += calcMetricDiff(a[a.length-1], trials, 2.0 / 15.0);

    System.out.println(""+metric);
}   

private static double calcMetricDiff(double val, int trials, double diff) {
    return Math.abs((val / trials) - diff);
}