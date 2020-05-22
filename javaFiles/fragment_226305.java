public static void main(String[] args) {

    double[][] indexMatrix = new double[][] {
                  new double[] { 1.02, 100 }, 
                  new double[] { 1.03, 123 },
                  new double[] { 1.01, 321 } };

    Arrays.sort(indexMatrix, new Comparator<double[]>() {
        @Override
        public int compare(double[] o1, double[] o2) {
            return Double.compare(o2[0], o1[0]);
        }
    });

    for (double[] d : indexMatrix)
        System.out.println(Arrays.toString(d));
}