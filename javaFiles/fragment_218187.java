Arrays.sort(myArr, new Comparator<int[]>() {
    public int compare(int[] o1, int[] o2) {
        int ret = Integer.compare(o1[2], o2[2]);
        // if the entries are equal at index 2, compare index 1
        if (0 == ret) {
            ret = Integer.compareTo(o1[1], o2[1]);
        }
        return (ret);
    }
});