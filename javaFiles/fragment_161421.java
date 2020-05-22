static void getMetric(int[] a, int trials){
    double metric = Math.abs((((double)a[0]) / trials) - (2 / 15));

    for (int i = 1; i < 7; i++) {
        metric += Math.abs((((double)a[i]) / trials) - 0.1);
    }

    metric += Math.abs((((double)a[7]) / trials) - (2 / 15));

    System.out.println(""+metric);
}