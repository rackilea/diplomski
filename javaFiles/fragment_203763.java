Arrays.sort(twoDim, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return ((Integer) o2[0]).compareTo(o1[0]);
    }
});