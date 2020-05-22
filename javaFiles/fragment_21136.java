final double[] scores = // acquire scores
Integer[] indices = new Integer[scores.length];
Arrays.sort(indexes, new Comparator<Integer>() {
    @Override public int compare(Integer i, Integer j) {
        return -Double.compare(scores[i], scores[j]);
    }
});