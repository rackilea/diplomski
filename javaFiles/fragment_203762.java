Arrays.sort(twoDim, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o2[0], o1[0]);
    }
});