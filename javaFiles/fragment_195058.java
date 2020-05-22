public static void sortMyArray() {
    Arrays.sort(myArray, new Comparator<double[]>() {
        public int compare(double[] a, double[] b) {
            int result = Double.compare(a[2], b[2]); 
            if (result == 0) {
                return Double.compare(a[3], b[3]);
            } else {
                return result;
            }
        }
    });
}