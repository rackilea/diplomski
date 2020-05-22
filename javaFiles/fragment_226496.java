final double[] distances=new double[]{3.2, 1.4, 7.3, 2.2, 9.1};
Integer[] sortedIDXs  = new Integer[]{0,1,2,3,4};
Arrays.sort(sortedIDXs, new Comparator<Integer>() {
    public int compare(Integer idx1, Integer idx2) {
        return Double.compare(distances[idx1], distances[idx2]);
    }
});